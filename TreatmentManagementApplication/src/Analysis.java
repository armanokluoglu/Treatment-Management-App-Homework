public abstract class Analysis {

	private Patient patient;
	
	public Analysis(Patient patient) {
		setPatient(patient);
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		if(patient == null) {
			throw new IllegalArgumentException("Given patient is null.");
		}
		this.patient = patient;
	}
	
	public abstract String toString(); //For a better printing of analysis reports.
	
}