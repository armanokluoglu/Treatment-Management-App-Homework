public class Doctor {
	public Hospital hospital;
	public String firstName;
	public String lastName;
	
	public Doctor(Hospital hospital, String firstName, String lastName) {
		setHospital(hospital);
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Hospital getHospital() {
		return hospital;
	}
	
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	private void setFirstName(String firstName) {
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