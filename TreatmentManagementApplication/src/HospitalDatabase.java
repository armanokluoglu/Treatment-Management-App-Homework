import java.util.ArrayList;
import java.util.List;

public class HospitalDatabase {
	private List<Analysis> analyses;
	private List<Doctor> doctors;
	private List<Patient> patients;
	
	public HospitalDatabase(List<Patient> patients, List<Doctor> doctors) {
		setDoctors(doctors);
		setPatients(patients);
		analyses = new ArrayList<Analysis>();
	}
	
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
		
	}
	
	public List<Patient> getPatients() { return patients; }
	
	public List<Doctor> getDoctors() { return doctors; }
	
	public List<Analysis> getAnalyzes(){return analyses;}
	
	public void setAnalyzes(List<Analysis> analyzes) {
		if(analyzes == null) {
			throw new IllegalArgumentException("Given analysis list is null.");
		}
		this.analyses = analyzes;
	}
	
	public void addAnAnalysis(Analysis anAnalysis) {
		if(anAnalysis == null) {
			throw new IllegalArgumentException("Given analysis is null.");
		}
		analyses.add(anAnalysis);
	}
	
	public List<Analysis> findTheAnalysis(String patientName) throws AnalysisNotFoundException {
		if(patientName == null) {
			throw new IllegalArgumentException("Given patient name is null.");
		}
		List<Analysis> list = new ArrayList<>();
		for(Analysis nextAnalysis: analyses) {
			if(nextAnalysis.getPatient().getFullName().equals(patientName)) {
				list.add(nextAnalysis);
			}
		}
		if(list.size() == 0) {
			throw new AnalysisNotFoundException("Analysis with given patient could not be found.");
		}
		return list;
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