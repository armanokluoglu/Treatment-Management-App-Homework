import java.util.ArrayList;
import java.util.List;

public class Hospital {
	private String name;
	private Receptionist receptionist;
	private HospitalDatabase hospitalDatabase;
	
	public Hospital(String name) {
		setName(name);
		this.receptionist = null;
		hospitalDatabase = new HospitalDatabase(new ArrayList<Patient>(), new ArrayList<Doctor>());
	}
	
	public Hospital(String name, List<Patient> patients, List<Doctor> doctors, Receptionist receptionist) {
		setName(name);
		setPatients(patients);
		setDoctors(doctors);
		HospitalDatabase hospitalDatabase = new HospitalDatabase(new ArrayList<Patient>(), new ArrayList<Doctor>());
		setHospitalDatabase(hospitalDatabase);
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		if(name == "" || name == " " || name == null) {
			throw new IllegalArgumentException("Given hospital name cannot be empty.");
		}
		this.name = name;
	}
	
	public Receptionist getReceptionist() {
		return receptionist;
	}
	
	public void setReceptionist(Receptionist receptionist) {
		if(receptionist == null) {
			throw new IllegalArgumentException("Given receptionist cannot be null.");
		}
		this.receptionist = receptionist;
	}
	
	public List<Patient> getPatients() {
		return hospitalDatabase.getPatients();
	}
	
	public void setPatients(List<Patient> patients) {
		if(patients == null) {
			throw new IllegalArgumentException("Given patient list is null.");
		}
		hospitalDatabase.setPatients(patients);
	}
	
	public List<Doctor> getDoctors() {
		return hospitalDatabase.getDoctors();
	}
	
	public void setDoctors(List<Doctor> doctors) {
		if(doctors == null) {
			throw new IllegalArgumentException("Given doctor list is null.");
		}
		hospitalDatabase.setDoctors(doctors);
	}
	
	public void addDoctor(Doctor doctor) {
		if(doctor == null) {
			throw new IllegalArgumentException("Given doctor is null.");
		}
		hospitalDatabase.addDoctor(doctor);
	}
	
	public void addPatient(Patient patient) {
		if(patient == null) {
			throw new IllegalArgumentException("Given patient is null.");
		}
		hospitalDatabase.addPatient(patient);
	}

	public HospitalDatabase getHospitalDatabase() {
		return hospitalDatabase;
	}

	private void setHospitalDatabase(HospitalDatabase hospitalDatabase) {
		if(hospitalDatabase == null) {
			throw new IllegalArgumentException("Given hospital database is null.");
		}
		this.hospitalDatabase = hospitalDatabase;
	}

	public List<Analysis> searchAnalysis(String patientName) throws AnalysisNotFoundException {
		if(patientName == null) {
			throw new IllegalArgumentException("Given patient name cannot be null.");
		}
		return hospitalDatabase.findTheAnalysis(patientName);
	}
}