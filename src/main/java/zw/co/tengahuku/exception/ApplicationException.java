package zw.co.tengahuku.exception;

import org.springframework.context.ApplicationContext;

public abstract class ApplicationException extends RuntimeException{
	 	private static final long serialVersionUID = 1L;
	    public static final String APPLICATION_NAME_PROPERTY = "spring.application.name";
	    public static final String CONTEXT_PROPERTY = "context";
	    private final ErrorDetail errorDetail = ErrorDetail.builder().build();

	    public ApplicationException(String message, Integer code,HttpStatus status, String type) {
	        super(message);
	        this.errorDetail.setContext(this.getProperty("context"));
	        this.errorDetail.setService(this.getProperty("spring.application.name"));
	        this.errorDetail.setCode(code);
	        this.errorDetail.setType(type);
	        this.errorDetail.setMessage(message);
	    }

	    public ApplicationException(String message, String string, Integer code,String type) {
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

	    public abstract zw.co.tengahuku.exception.HttpStatus getHTTPStatusCode();

	    private String getProperty(String propertyName) {
			return propertyName;
	       // ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
	      //  return applicationContext == null ? "" : applicationContext.getEnvironment().getProperty(propertyName);
	    }
}
