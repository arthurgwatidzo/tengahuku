package zw.co.tengahuku.exception;


public enum MssErrorCode implements ErrorCode{
	 	ID_ON_CREATE(Integer.valueOf(24091), "ID supplied on create request"),
	    NO_ID_ON_UPDATE(Integer.valueOf(24092), "No ID supplied on update request"),
	    APP_ERROR(Integer.valueOf(24093), "Application Error"),
	    DATA_INIT_ERROR(Integer.valueOf(24095), "Data Initialisation Error"),
	    INVALID_LOCALE(Integer.valueOf(24096), "The locale supplied on request is invalid"),
	    NO_LOCALE(Integer.valueOf(24097), "The locale supplied on request is invalid"),
	    TRANSLATION_RECORD_NOT_FOUND(Integer.valueOf(24098), "Could not obtain translation record"),
	    EMPTY_LIST_REQUEST_BODY(Integer.valueOf(24100), "Empty list supplied on create request");

	    private Integer code;
	    private String message;

	    private MssErrorCode(Integer code, String message) {
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
