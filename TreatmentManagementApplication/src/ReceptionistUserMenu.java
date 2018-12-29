import java.util.Scanner;

public class ReceptionistUserMenu {

	private Receptionist receptionist;
	
	public ReceptionistUserMenu(Receptionist receptionist) {
		this.receptionist = receptionist;
	}
	
	@SuppressWarnings("resource")
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
					scanner.nextLine();
					System.out.print("Enter the name of the patient (ex: Chris Pine): ");
					String patientName = scanner.nextLine();
					System.out.print("Please enter the doctor's last name here: ");
					String docName = scanner.nextLine();
					Doctor doc =  null;
					if(docName.equals("House")) {
						doc = doc1;
					}else if(docName.equals("Cox")) {
						doc = doc2;
					}else if(docName.equals("Strange")) {
						doc = sur1;
					}else if(docName.equals("Turk")) {
						doc = sur2;
					}else {
						scanner.close();
						throw new IllegalArgumentException("Invalid doctor.");
					}
					System.out.print("Please enter a date for the appointment (yyyy-mm-dd): ");
					String appointmentDate = scanner.nextLine();
					Date apDate = new Date(appointmentDate);
					receptionist.registerAPatient(doc, new WalkingCasePatient(hospital, patientName), apDate);
					System.out.println("Patient registered.");
				} else if(recOpNum == 0) {
					break;
					
				} else {
					try {
						throw new InvalidOperationNumberException();
					} catch (InvalidOperationNumberException e) {
						System.out.println("Invalid entry, try again.\n");
						continue;
					}
				}
			}
		} else {
			try {
				throw new InvalidOperationNumberException();
			} catch (InvalidOperationNumberException e) {
				System.out.println("Invalid entry, try again.\n");
				presentMenu(doc1, doc2, sur1, sur2, hospital);
			}
		}
	}
}
