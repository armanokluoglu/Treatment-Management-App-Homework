import java.util.Scanner;

public class ReceptionistUserMenu {

	private Receptionist receptionist;
	
	public ReceptionistUserMenu(Receptionist receptionist) {
		this.receptionist = receptionist;
	}
	
	public void presentMenu(Doctor doc1, Doctor doc2, Doctor sur1, Doctor sur2, Hospital hospital) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Receptionists:");
		System.out.println("1. " + receptionist.getFullName());
		int receptionistUser = scanner.nextInt();
		if(receptionistUser == 1) {
			System.out.println("Welcome " + receptionist.getFullName());
			while(true) {
				System.out.println("Available Operations:");
				System.out.println("0. Exit Program");
				System.out.println("1. Register Patient");
				int recOpNum = scanner.nextInt();
				if(recOpNum == 1) {
					System.out.print("Enter the name of the patient (ex: Chris Pine): ");
					String patientName = scanner.nextLine();
					System.out.print("Please enter the doctor's last name here: ");
					String docName = scanner.nextLine();
					Doctor doc =  null;
					if(docName == "House") {
						doc = doc1;
					}else if(docName == "Cox") {
						doc = doc2;
					}else if(docName == "Strange") {
						doc = sur1;
					}else if(docName == "Turk") {
						doc = sur2;
					}else {
						scanner.close();
						throw new IllegalArgumentException("Invalid doctor.");
					}
					System.out.print("Please enter a date for the appointment (yyyy-mm-dd): ");
					String appointmentDate = scanner.nextLine();
					Date apDate = new Date(appointmentDate);
					receptionist.registerAPatient(doc, new Patient(hospital, patientName), apDate);
					
				} else if(recOpNum == 0) {
					scanner.close();
					break;
					
				} else {
					scanner.close();
					throw new IllegalArgumentException("Invalid operation number.");
				}
			}
		} else {
			scanner.close();
			throw new IllegalArgumentException("Invalid operation number.");
		}
	}
}
