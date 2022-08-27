package namoo.yorizori.common.web;

public class YZRuntimeException extends RuntimeException {
	private String redirectURL;
	
	public YZRuntimeException(String message) {
		super(message);
	}
	
	public YZRuntimeException(String message, String redirectURL) {
		super(message);
		this.redirectURL = redirectURL;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}
}
