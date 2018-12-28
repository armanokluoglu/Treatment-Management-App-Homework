
public class Prescription {
	
	private String name;
	private double dosage;

	public Prescription(String name, double dosage) {
		this.name = name;
		this.dosage = dosage;
	}

	public String getName() {
		return name;
	}

	public double getDosage() {
		return dosage;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDosage(double dosage) {
		this.dosage = dosage;
	}
	
	@Override
	public String toString() {
		return "Name of the medicine: " + name + "\n" + 
			   "Required dosage: " + dosage;
	}
}
