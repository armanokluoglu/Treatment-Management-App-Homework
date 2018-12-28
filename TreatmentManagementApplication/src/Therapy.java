public class Therapy extends Treatment {
	private Patient patient;

	public Therapy(Patient patient) {
		setPatient(patient);
	}
	
	@Override
	public void startTreatment() {
		// TODO Auto-generated method stub
		
	}

	public Patient getPatient() {
		return patient;
	}

	private void setPatient(Patient patient) {
		this.patient = patient;
	}
}