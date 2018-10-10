public class ErrorException extends Exception {
	//Rev 2
	public static enum ErrorID{
		CYCLE,
		ISLAND,
		NO_PREDECESSOR;
	}
	
	private Node node;
	
	private ErrorID ErrorType;

	public ErrorException() {
		// TODO Auto-generated constructor stub
	}
	
	public ErrorException(ErrorID Error, Node node) {
		ErrorType = Error;
		this.node = node;
	}
	
	public ErrorException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ErrorException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ErrorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ErrorException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
	public ErrorID getErrorID() {
		return ErrorType;
	}
	public String toString() {
		return ErrorType.toString() + " at node " + node;
	}
}