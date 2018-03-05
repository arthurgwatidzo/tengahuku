package zw.co.tengahuku.exception;


public class ApplicationDataException extends ApplicationException{
	
	protected static final HttpStatus DEFAULT_RESPONSES_CODE;
	    protected static final MssErrorCode DEFAULT_ERROR_CODE;
	    private final HttpStatus responseCode;
	    private final Throwable cause;

	    public ApplicationDataException(String message) {
	        this(message, (Throwable)null, DEFAULT_RESPONSES_CODE);
	    }

	    public ApplicationDataException(String message, Throwable throwable) {
	        this(message, throwable, DEFAULT_RESPONSES_CODE);
	    }

	    public ApplicationDataException(String message, HttpStatus status) {
	        this(message, (Throwable)null, status);
	    }

	    public ApplicationDataException(String message, Throwable throwable, HttpStatus status) {
	        this(message, throwable, status, DEFAULT_ERROR_CODE);
	    }

	    public ApplicationDataException(String message, Throwable throwable, HttpStatus status, MssErrorCode defaultErrorCode) {
	        super(message, (String)null, null, message);
	        this.getErrorDetail().setType(this.getClass().getSimpleName());
	        this.cause = throwable;
	        this.responseCode = status;
	    }

	    public Throwable getCause() {
	        return this.cause == this ? null : this.cause;
	    }

	    public HttpStatus getHTTPStatusCode() {
	        return this.responseCode;
	    }

	    static {
	        DEFAULT_RESPONSES_CODE = HttpStatus.BAD_REQUEST;
	        DEFAULT_ERROR_CODE = MssErrorCode.APP_ERROR;
	    }
}
