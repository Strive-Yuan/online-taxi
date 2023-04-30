package exception;

import com.api.response.ResponseEnum;

public class VerificationCodeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Object object;

	private ResponseEnum responseEnum;

	public VerificationCodeException(String msg) {
		super(msg);
	}

	public VerificationCodeException(String msg, Object object) {
		super(msg);
		this.object = object;
	}

	public VerificationCodeException(String msg, Throwable cause) {
		super(msg, cause);
	}


	public VerificationCodeException(ResponseEnum responseEnum) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
	}

	public VerificationCodeException(ResponseEnum responseEnum, Object object) {
		super(responseEnum.getMsg());
		this.responseEnum = responseEnum;
		this.object = object;
	}


	public Object getObject() {
		return object;
	}

	public ResponseEnum getResponseEnum() {
		return responseEnum;
	}

}
