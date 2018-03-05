package zw.co.tengahuku.utilities;

import org.springframework.stereotype.Component;


@Component
public class BaseEntityListenerBean {
    public BaseEntityListenerBean() {
    }

    public void prePersist(BaseEntity object) {
        this.setFieldValues(object);
    }

    public void preUpdate(BaseEntity object) {
        this.setFieldValues(object);
    }

    public void postUpdate(BaseEntity object) {
    }

    public void postPersist(BaseEntity object) {
    }

    private void setFieldValues(BaseEntity object) {
        ContextProperty contextProperty = this.getContextProperty(RequestContextConstants.TRANSACTION_ID);
        if (contextProperty != null) {
            object.setAuditTransactionId(contextProperty.getValue());
        }

        contextProperty = this.getContextProperty(RequestContextConstants.USER_ID);
        if (contextProperty != null) {
            object.setAuditUserId(contextProperty.getValue());
        }

    }

    private ContextProperty getContextProperty(RequestContextConstants requestContextConstants) {
        return RequestContext.get().getContextProperty(requestContextConstants.getProperty());
    }
}
