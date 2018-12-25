import java.util.ArrayList;
import java.util.List;

public class Hospital {
	public String name;
	public Receptionist receptionist;
	public List<Patient> patients;
	public List<Doctor> doctors;
	
	public Hospital(String name) {
		setName(name);
		setReceptionist(null);
		setPatients(new ArrayList<>());
		setDoctors(new ArrayList<>());
	}
	
	public Hospital(String name, List<Patient> patients, List<Doctor> doctors, Receptionist receptionist) {
		setName(name);
		setPatients(patients);
		setDoctors(doctors);
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public Receptionist getReceptionist() {
		return receptionist;
	}
	
	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public List<Doctor> getDoctors() {
		return doctors;
	}
	
	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
	
	public void addPatient(Patient patient) {
		patients.add(patient);
	}
}