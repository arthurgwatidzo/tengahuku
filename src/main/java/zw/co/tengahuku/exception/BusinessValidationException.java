package zw.co.tengahuku.exception;

public class BusinessValidationException extends ApplicationException{
	private static final long serialVersionUID = 1L;
    private static final String ERROR_TYPE = BusinessValidationException.class.getSimpleName();

    /** @deprecated */
    @Deprecated
    public BusinessValidationException(String message, Integer code) {
        super(message, code, null, ERROR_TYPE);
    }

    public BusinessValidationException(String message, ErrorCode errCode) {
        super(message, message, errCode.getCode(), ERROR_TYPE);
    }

//	public BusinessValidationException(ErrorCode errCode, Object... params) {
//		super(String.format(errCode.getMessage(), params), errCode.getCode(), ERROR_TYPE);
//	}

    public HttpStatus getHTTPStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}


