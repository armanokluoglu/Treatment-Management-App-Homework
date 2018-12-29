public class Patient {
	
	private Hospital hospital;
	private String fullName;
	private Examination examination;
	private boolean isExamined;
	private Appointment<Patient, Doctor> appointment;
	
	public Patient(Hospital hospital, String fullName) {
		setHospital(hospital);
		setFullName(fullName);
		isExamined = false;
		setExamination(null);
		setAppointment(null);
	}
		
	public boolean isExamined() {
		return isExamined;
	}
	
	public void setExamined(Doctor doctor) {
		this.isExamined = true;
		setExamination(new Examination(this, doctor));
	}

	public Hospital getHospital() {
		return hospital;
	}
	
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	private void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Appointment<Patient, Doctor> getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment<Patient, Doctor> appointment) {
		this.appointment = appointment;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (this.equals(other)) {
			return true;
		}
		return false;
	}

	public boolean equals(Patient patient) {
		if(getFullName() == patient.getFullName()) {
			return true;
		}
		return false;
	}

	public Examination getExamination() {
		return examination;
	}

	private void setExamination(Examination examination) {
		this.examination = examination;
	}
}