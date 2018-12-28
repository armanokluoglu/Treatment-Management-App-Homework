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
		this.patient = patient;
	}

	public void setDoctor(D doctor) {
		this.doctor = doctor;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	@Override
	public String toString() {
		return "Appointment Doctor: " + doctor + "\n" + 
			   "Appointment Patient: " + patient + "\n" + 
			   "Appointment Date: " + appointmentDate;
	}
}