public class Examination {
	private Patient patient;
	private Doctor doctor;
	private Date examinationDate;
	private RadiologyAnalysis ra;
	private BloodTestAnalysis bta;
	
	public Examination(Patient patient, Doctor doctor) {
		setPatient(patient);
		setDoctor(doctor);
		setExaminationDate(Date.getCurrentDate());
		setRa(null);
		setBta(null);
	}
	
	public RadiologyAnalysis requestRadiology() {
		if(getRa() == null) {
			setRa(new RadiologyAnalysis(patient));
		}
		return getRa();
	}
	
	public BloodTestAnalysis requestBloodTest() {
		if(getBta() == null) {
			setBta(new BloodTestAnalysis(patient));
		}
		return getBta();
	}
	
	public void startTreatment(Treatment treatment) {
		treatment.startTreatment();
	}
	
	
	public RadiologyAnalysis getRa() {
		return ra;
	}

	public void setRa(RadiologyAnalysis ra) {
		this.ra = ra;
	}

	public BloodTestAnalysis getBta() {
		return bta;
	}

	public void setBta(BloodTestAnalysis bta) {
		this.bta = bta;
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