public class InmatePatient extends Patient {
	
	public InmatePatient(Hospital hospital, String fullName) {
		super(hospital, fullName);
	}
	
	public InmatePatient(Patient aPatient) {
		this(aPatient.getHospital(), aPatient.getFullName());
	}
}