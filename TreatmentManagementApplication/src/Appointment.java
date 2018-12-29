public class Appointment<P extends Patient, D extends Doctor> {
	private P patient;
	private D doctor;
	private Date appointmentDate;
	
	public Appointment(P patient, D doctor, Date appointmentDate) {
		setPatient(patient);
		setDoctor(doctor);
		setAppointmentDate(appointmentDate);
	}

	public P getPatient() {
		return patient;
	}

	public D getDoctor() {
		return doctor;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setPatient(P patient) {
		if(patient == null) {
			throw new IllegalArgumentException("Given patient is null.");
		}
		this.patient = patient;
	}

	public void setDoctor(D doctor) {
		if(doctor == null) {
			throw new IllegalArgumentException("Given doctor is null.");
		}
		this.doctor = doctor;
	}

	public void setAppointmentDate(Date appointmentDate) {
		if(appointmentDate == null) {
			throw new IllegalArgumentException("Given appointment date is null.");
		}
		this.appointmentDate = appointmentDate;
	}
	
	@Override
	public String toString() {
		return "Appointment Doctor: " + doctor + "\n" + 
			   "Appointment Patient: " + patient + "\n" + 
			   "Appointment Date: " + appointmentDate;
	}
}