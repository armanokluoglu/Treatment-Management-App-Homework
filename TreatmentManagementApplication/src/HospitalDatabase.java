import java.util.ArrayList;
import java.util.List;

public class HospitalDatabase {

	private List<Analysis> analyzes;
	private List<Doctor> doctors;
	private List<Patient> patients;
	
	public HospitalDatabase(List<Patient> patients, List<Doctor> doctors) {
		setDoctors(doctors);
		setPatients(patients);
		analyzes = new ArrayList<Analysis>();
	}
	
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
		
	}
	
	public List<Patient> getPatients() { return patients; }
	
	public List<Doctor> getDoctors() { return doctors; }
	
	
	public List<Analysis> getAnalyzes(){return analyzes;}
	
	public void setAnalyzes(List<Analysis> analyzes) {
		if(analyzes == null) {
			throw new IllegalArgumentException("Given analysis list is null.");
		}
		this.analyzes = analyzes;
	}
	
	public void addAnAnalysis(Analysis anAnalysis) {
		if(anAnalysis == null) {
			throw new IllegalArgumentException("Given analysis is null.");
		}
		analyzes.add(anAnalysis);
	}
	
	public Analysis findTheAnalysis(String patientName) throws AnalysisNotFoundException {
		if(patientName == null) {
			throw new IllegalArgumentException("Given patient name is null.");
		}
		for(Analysis nextAnalysis: analyzes) {
			if(nextAnalysis.getPatient().getFullName() == patientName) {
				return nextAnalysis;
			}
		}
		throw new AnalysisNotFoundException("Analysis with given patient could not be found.");
	}

	public void addPatient(Patient patient) {
		if(patient == null) {
			throw new IllegalArgumentException("Given patient is null.");
		}
		patients.add(patient);
	}
	
	public void addDoctor(Doctor doctor) {
		if(doctor == null) {
			throw new IllegalArgumentException("Given doctor is null.");
		}
		doctors.add(doctor);
	}
}
