public class Surgeon extends Doctor {
	
	public Surgeon(Hospital hospital, String firstName, String lastName) {
		super(hospital, firstName, lastName);
	}
	
	public SurgeryAppointment searchForASurgeryAppointment(Receptionist receptionist) {
		return receptionist.getSurgeryAppointmentForSurgeon(this);
	}
	
	public void startSurgeryOnPatient(Patient patient) {
		Surgery surgery = new Surgery(this, patient);
		surgery.startTreatment();
	}
}