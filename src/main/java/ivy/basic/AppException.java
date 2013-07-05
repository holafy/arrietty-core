package ivy.basic;

import ivy.basic.ViException;

/**
 * 应用错误
 * 
 * @author holaivy@gmail.com
 * 
 */
public class AppException extends ViException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppException() {
		super();
		
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AppException(String message) {
		super(message);
		
	}

	public AppException(Throwable cause) {
		super(cause);
		
	}

}
