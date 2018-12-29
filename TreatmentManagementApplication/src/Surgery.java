public class Surgery extends Treatment {
	private Surgeon surgeon;
	private Patient patient;
	
	public Surgery(Surgeon surgeon, Patient patient) {
		setSurgeon(surgeon);
		setPatient(patient);
	}

	@Override
	public void startTreatment() {
		this.patient = new InmatePatient(getPatient());
		// TODO Auto-generated method stub
	}
	
	public Surgeon getSurgeon() {
		return surgeon;
	}
	
	private void setSurgeon(Surgeon surgeon) {
		this.surgeon = surgeon;
	}

	public Patient getPatient() {
		return patient;
	}

	private void setPatient(Patient patient) {
		this.patient = patient;
	}
}