package zw.co.tengahuku.exception;

public class OrderException extends ApplicationDataException{
	public OrderException(String message) {
        this(message, (Throwable) null, DEFAULT_ERROR_CODE);
    }

    public OrderException(String message, ErrorCode errorCode) {
        this(message, null, DEFAULT_RESPONSES_CODE, errorCode);
    }

    public OrderException(String message, Throwable throwable) {
        this(message, throwable, DEFAULT_RESPONSES_CODE, DEFAULT_ERROR_CODE);
    }

    public OrderException(String message, HttpStatus status) {
        this(message, null, status, DEFAULT_ERROR_CODE);
    }

    public OrderException(String message, Throwable throwable, ErrorCode errorCode) {
        this(message, throwable, DEFAULT_RESPONSES_CODE, errorCode);
    }

    public OrderException(String message, HttpStatus status, ErrorCode errorCode) {
        this(message, null, status, errorCode);
    }

    public OrderException(String message, Throwable throwable, HttpStatus status) {
        this(message, throwable, status, DEFAULT_ERROR_CODE);
    }

    public OrderException(String message, Throwable throwable, HttpStatus status, ErrorCode errorCode) {
        super(message, throwable, status);
    }
}
