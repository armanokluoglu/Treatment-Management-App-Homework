@SuppressWarnings("serial")
public class PatientNotFoundException extends Exception {
	public PatientNotFoundException() {
		super();
	}
	
	public PatientNotFoundException(String msg) {
		super(msg);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}