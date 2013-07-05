package ivy.basic;

/**
 * @author holaivy
 * 
 */
public class ViException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9069284112496834158L;

	public ViException() {
		super();

	}

	public ViException(String message, Throwable cause) {
		super(message, cause);

	}

	public ViException(String message) {
		super(message);

	}

	public ViException(Throwable cause) {
		super(cause);

	}

	private int code;
	private String key;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
