public class Examination {
	
	private Patient patient;
	private Doctor doctor;
	private Date examinationDate;
	
	public Examination(Patient patient, Doctor doctor) {
		setPatient(patient);
		setDoctor(doctor);
		setExaminationDate(Date.getCurrentDate());
	}
	
	public RadiologyAnalysis requestRadiology() {
		return new RadiologyAnalysis(patient);
	}
	
	public BloodTestAnalysis requestBloodTest() {
		return new BloodTestAnalysis(patient);
	}
	
	public void startTreatment(Treatment treatment) {
		treatment.startTreatment();
	}
	
	public Patient getPatient() {
		return patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	private void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getExaminationDate() {
		return examinationDate;
	}

	private void setExaminationDate(Date examinationDate) {
		this.examinationDate = examinationDate;
	}
	
	
}