public class Receptionist {
	public Hospital hospital;
	public String fullName;
	
	public Receptionist(Hospital hospital, String fullName) {
		setHospital(hospital);
		setFullName(fullName);
	}
	
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public String getFullName() {
		return fullName;
	}
	private void setFullName(String fullName) {
		this.fullName = fullName;
	}
}