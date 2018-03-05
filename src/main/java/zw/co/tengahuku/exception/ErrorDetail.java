package zw.co.tengahuku.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.beans.ConstructorProperties;
import java.io.Serializable;

@ApiModel(value = "ErrorDetail",description = "Error Detail")
public class ErrorDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;
    @ApiModelProperty("The context the error happened in e.g. Agreement")
    private String context;
    @ApiModelProperty("The service that the error happened in e.g. Membership Agreement")
    private String service;
    @ApiModelProperty("The internal error code e.g. 10001")
    private Integer code;
    @ApiModelProperty("The internal error type e.g. BusinessValidationException")
    private String type;
    @ApiModelProperty("The internal error message")
    private String message;

    public static ErrorDetail.ErrorDetailBuilder builder() {
        return new ErrorDetail.ErrorDetailBuilder();
    }

    public String getContext() {
        return this.context;
    }

    public String getService() {
        return this.service;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    protected boolean canEqual(Object other) {
        return other instanceof ErrorDetail;
    }


    

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorDetail other = (ErrorDetail) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public String toString() {
        return "ErrorDetail(context=" + this.getContext() + ", service=" + this.getService() + ", code=" + this.getCode() + ", type=" + this.getType() + ", message=" + this.getMessage() + ")";
    }

    public ErrorDetail() {
    }

    @ConstructorProperties({"context", "service", "code", "type", "message"})
    public ErrorDetail(String context, String service, Integer code, String type, String message) {
        this.context = context;
        this.service = service;
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public static class ErrorDetailBuilder {
        private String context;
        private String service;
        private Integer code;
        private String type;
        private String message;

        ErrorDetailBuilder() {
        }

        public ErrorDetail.ErrorDetailBuilder context(String context) {
            this.context = context;
            return this;
        }

        public ErrorDetail.ErrorDetailBuilder service(String service) {
            this.service = service;
            return this;
        }

        public ErrorDetail.ErrorDetailBuilder code(Integer code) {
            this.code = code;
            return this;
        }

        public ErrorDetail.ErrorDetailBuilder type(String type) {
            this.type = type;
            return this;
        }

        public ErrorDetail.ErrorDetailBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorDetail build() {
            return new ErrorDetail(this.context, this.service, this.code, this.type, this.message);
        }

        public String toString() {
            return "ErrorDetail.ErrorDetailBuilder(context=" + this.context + ", service=" + this.service + ", code=" + this.code + ", type=" + this.type + ", message=" + this.message + ")";
        }
    }
}
