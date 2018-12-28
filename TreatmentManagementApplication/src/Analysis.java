public abstract class Analysis {

	private Patient patient;
	
	public Analysis(Patient patient) {
		this.patient = patient;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public abstract String toString(); //For a better printing of analysis reports.
	
}