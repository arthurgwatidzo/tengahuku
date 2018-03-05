package zw.co.tengahuku.exception;

import org.springframework.context.ApplicationContext;

public abstract class BusinessException extends RuntimeException{
	private static final long serialVersionUID = 1L;
    public static final String APPLICATION_NAME_PROPERTY = "spring.application.name";
    public static final String CONTEXT_PROPERTY = "context";
    private final ErrorDetail errorDetail = ErrorDetail.builder().build();

    public BusinessException(String message, Integer code, String type) {
        super(message);
        this.errorDetail.setContext(this.getProperty("context"));
        this.errorDetail.setService(this.getProperty("spring.application.name"));
        this.errorDetail.setCode(code);
        this.errorDetail.setType(type);
        this.errorDetail.setMessage(message);
    }

    public ErrorDetail getErrorDetail() {
        return this.errorDetail;
    }

    public abstract HttpStatus getHTTPStatusCode();

    private String getProperty(String propertyName) {
    	ApplicationContext applicationContext = ApplicationContextProvider.getBusinessApplicationContext();
        return applicationContext == null ? "" : applicationContext.getEnvironment().getProperty(propertyName);
    }

}
