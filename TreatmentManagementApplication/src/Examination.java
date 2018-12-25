public class Examination {
	private String diagnosis;
	private Patient patient;
	private Doctor doctor;
	
	public Examination(Patient patient, Doctor doctor) {
		setDiagnosis("No diagnosis.");
		setPatient(patient);
		setDoctor(doctor);
	}
	
	public Analysis requestAnalysis() {
		//
	}
	
	public void startTreatment() {
		//
	}
	
	public String getDiagnosis() {
		return diagnosis;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Patient getPatient() {
		return patient;
	}

	private void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
}