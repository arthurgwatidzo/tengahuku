package zw.co.tengahuku.utilities;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.springframework.util.StringUtils;

import zw.co.tengahuku.model.Supplier;

public class RequestContext {
    private static final Long MILLIS_PER_SECOND = 1000L;
    private static final ThreadLocal<RequestContext> instanceHolder = new ThreadLocal();
    private long startedWhenNanos = System.nanoTime();
    private Map<String, ContextProperty> contextProperties = new HashMap();
    private Object requestObject;
    private Supplier tenant;

    public RequestContext(Object requestObject, Supplier tenant, Map<String, ContextProperty> contextProperties) {
        this.requestObject = requestObject;
        this.tenant = tenant;
        this.contextProperties = contextProperties;
    }

    public static RequestContext.RequestContextBuilder builder() {
        return new RequestContext.RequestContextBuilder();
    }

    public static RequestContext get() {
        RequestContext context = (RequestContext)instanceHolder.get();
        if (context == null) {
            context = builder().build();
            instanceHolder.set(context);
        }

        return context;
    }

    public static void clear() {
        instanceHolder.remove();
    }

    public static void set(RequestContext newContext) {
        instanceHolder.set(newContext);
    }

    public ContextProperty getContextProperty(String name) {
        return !StringUtils.hasText(name) ? null : (ContextProperty)this.contextProperties.get(name.toLowerCase());
    }

    public Collection<ContextProperty> getContextProperties() {
        return this.contextProperties.values();
    }

    public long getStartedWhenNanos() {
        return this.startedWhenNanos;
    }

    public Object getRequestObject() {
        return this.requestObject;
    }

    public Supplier getTenant() {
        return this.tenant;
    }

    public String toString() {
        return "RequestContext(contextProperties=" + this.getContextProperties() + ", tenant=" + this.getTenant() + ")";
    }

    public static class RequestContextBuilder {
        private Object requestObject;
        private Supplier tenant;
        private Map<String, ContextProperty> contextProperties;

        public RequestContext build() {
            return new RequestContext(this.requestObject, this.tenant, this.contextProperties);
        }

        public RequestContext.RequestContextBuilder requestContext(RequestContext toCopy) {
            this.requestObject = toCopy.getRequestObject();
            this.tenant = toCopy.getTenant();
            this.contextProperties = new HashMap(toCopy.contextProperties);
            return this;
        }

        public RequestContext.RequestContextBuilder requestObject(Object requestObject) {
            this.requestObject = requestObject;
            return this;
        }

      


        public RequestContext.RequestContextBuilder contextProperties(Stream<ContextProperty> propertyStream) {
            propertyStream.forEach(this::addContextProperty);
            if (!this.isPresent(RequestContextConstants.TRANSACTION_ID)) {
                this.addContextProperty(RequestContextConstants.TRANSACTION_ID, this.generateTransactionIdProperty());
            }

            if (!this.isPresent(RequestContextConstants.MESSAGE_ID)) {
                this.addContextProperty(RequestContextConstants.MESSAGE_ID, this.generateMessageIdProperty());
            }

            

            return this;
        }

        private boolean isPresent(RequestContextConstants property) {
            return this.contextProperties.keySet().stream().anyMatch((name) -> {
                return name.equalsIgnoreCase(property.getProperty());
            });
        }

        private void addContextProperty(ContextProperty contextProperty) {
            this.contextProperties.put(contextProperty.getName().toLowerCase(), contextProperty);
        }

        private void addContextProperty(RequestContextConstants property, ContextProperty contextProperty) {
            if (contextProperty != null) {
                this.contextProperties.put(property.getProperty().toLowerCase(), contextProperty);
            }

        }

        private ContextProperty generateTransactionIdProperty() {
            long utcSeconds = System.currentTimeMillis() / RequestContext.MILLIS_PER_SECOND.longValue();
            long randomNumber = ThreadLocalRandom.current().nextLong();
            String transactionId = Long.toHexString(utcSeconds) + "." + Long.toHexString(randomNumber);
            return new ContextProperty(RequestContextConstants.TRANSACTION_ID.getProperty(), transactionId);
        }

        private ContextProperty generateMessageIdProperty() {
            String messageId = Long.toHexString(ThreadLocalRandom.current().nextLong());
            return new ContextProperty(RequestContextConstants.MESSAGE_ID.getProperty(), messageId);
        }

        private ContextProperty getLocaleProperty(Locale locale) {
            return locale != null ? new ContextProperty(RequestContextConstants.LOCALE.getProperty(), locale.toString().toLowerCase()) : null;
        }

        public RequestContextBuilder() {
           
            this.contextProperties = new HashMap();
        }
    }
}