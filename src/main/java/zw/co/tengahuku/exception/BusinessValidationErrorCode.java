package zw.co.tengahuku.exception;

public enum BusinessValidationErrorCode implements ErrorCode{
	SUPPLIER_EXISTS(Integer.valueOf(10001), "Supplier already exists"),
	CANCELLATION_NOT_ALLOWED(Integer.valueOf(10002), "Cancellation not allowed"),
	ACTION_NOT_ALLOWED(Integer.valueOf(10003), "Action not allowed"),
	ACCOUNT_NOT_ELIGIBLE(Integer.valueOf(10004), "Account not eligible");
	private Integer code;
    private String message;

    private BusinessValidationErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
