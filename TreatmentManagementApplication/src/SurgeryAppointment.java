public class SurgeryAppointment extends Appointment<Patient, Doctor>{
	private int numberOfRestDays;
	
	@SuppressWarnings("null")
	public SurgeryAppointment(Patient patient, Doctor doctor, Date appointmentDate, int number) {
		super(patient, doctor, appointmentDate);
		Surgeon surgeon = null;
		if(!doctor.getClass().equals(surgeon.getClass())) {
			throw new IllegalArgumentException("Only surgeons can be appointed to a surgery.");
		}
		setNumberOfRestDays(number);
	}

	public int getNumberOfRestDays() {
		return numberOfRestDays;
	}

	public void setNumberOfRestDays(int numberOfRestDays) {
		this.numberOfRestDays = numberOfRestDays;
	}
	
	public void decreaseNumberOfRestDays() {
		setNumberOfRestDays(getNumberOfRestDays() - 1);
	}
}