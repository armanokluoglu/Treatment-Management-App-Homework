@SuppressWarnings("serial")
public class AnalysisNotFoundException extends Exception {
	public AnalysisNotFoundException() {
		super();
	}
	
	public AnalysisNotFoundException(String msg) {
		super(msg);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}