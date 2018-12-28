import java.util.ArrayList;
import java.util.List;

public class Receptionist {
	
	private Hospital<Patient> hospital;
	private String fullName;
	private List<Appointment<Patient, Doctor>> schedule;
	
	public Receptionist(Hospital<Patient> hospital, String fullName) {
		setHospital(hospital);
		setFullName(fullName);
		schedule = new ArrayList<Appointment<Patient, Doctor>>();
	}
	
	public void registerAPatient(Doctor doctor, Patient patient, Date appointmentDate) {
		getHospital().addPatient(patient);
		Appointment<Patient, Doctor> appointment = new Appointment<Patient, Doctor>(patient, doctor, appointmentDate);
		schedule.add(appointment);
	}
	
	public List<Appointment<Patient, Doctor>> getAppointmentsOfDate(Date date){
		List<Appointment<Patient, Doctor>> todaysSchedule = new ArrayList<Appointment<Patient, Doctor>>();
		for(Appointment<Patient, Doctor> appointment: getSchedule()) {
			if(appointment.getAppointmentDate().equals(date)){
				todaysSchedule.add(appointment);
			}
		}
		return todaysSchedule;
	}
	
	public List<Appointment<Patient, Doctor>> getSchedule()	{return schedule;}
	
	public Hospital<Patient> getHospital() {
		return hospital;
	}
	public void setHospital(Hospital<Patient> hospital) {
		this.hospital = hospital;
	}
	public String getFullName() {
		return fullName;
	}
	private void setFullName(String fullName) {
		this.fullName = fullName;
	}
}