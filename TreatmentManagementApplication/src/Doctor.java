import java.util.ArrayList;
import java.util.List;

public class Doctor {
	private Hospital<Patient> hospital;
	private String firstName;
	private String lastName;
	private List<Patient> examinedPatients;
	private List<Patient> patientsUnderCare;
	
	public Doctor(Hospital<Patient> hospital, String firstName, String lastName) {
		setHospital(hospital);
		setFirstName(firstName);
		setLastName(lastName);
		examinedPatients = new ArrayList<Patient>();
	}
	
	public Examination examine(Patient patient) {
		patient.setExamined(this);
		examinedPatients.add(patient);
		return new Examination(patient, this);
	}
	
	public RadiologyAnalysis requestRadiology(Examination examination) {
		return examination.requestRadiology();
	}
	
	public BloodTestAnalysis requestBloodTest(Examination examination) {
		return examination.requestBloodTest();
	}
	
	public Patient searchAnExaminedPatient(String name) {
		Patient searchedPatient = null;
		try {
			for(Patient patient: examinedPatients) {
				if(patient.getFullName().equals(name)) {
					searchedPatient = patient;
				}
			}
			if(searchedPatient == null) {
				throw new PatientNotFoundException("Patient with given name: " + name + " could not be found.");
			}
		}
		catch(PatientNotFoundException e){
			e.printStackTrace();
		}
		return searchedPatient;
	}
	
	public List<Patient> getAllExaminedPatients() {
		return examinedPatients;
	}
	
	public List<Patient> getAllPatientsUnderCare() {
		return patientsUnderCare;
	}
	
	
	public Hospital<Patient> getHospital() {
		return hospital;
	}
	
	public void setHospital(Hospital<Patient> hospital) {
		this.hospital = hospital;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName();
	}
}