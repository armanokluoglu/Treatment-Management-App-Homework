import java.util.Scanner;

public class TreatmentManagement {

	public void start() {
		Hospital hospital = new Hospital("Massachusetts General Hospital");
		Receptionist receptionist = new Receptionist(hospital, "Pam Beesley");
		hospital.setReceptionist(receptionist);
		Doctor doc1 = new Doctor(hospital, "Gregory", "House");
		Doctor doc2 = new Doctor(hospital, "Perry", "Cox");
		Doctor sur1 = new Surgeon(hospital, "Stephen", "Strange");
		Doctor sur2 = new Surgeon(hospital, "Christopher", "Turk");
		hospital.addDoctor(doc1);
		hospital.addDoctor(doc2);
		hospital.addDoctor(sur1);
		hospital.addDoctor(sur2);
		boolean flag = true;
		while(flag) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Massachusetts General Hospital Management Program");
			System.out.println("Please select your role:");
			System.out.println("0. Exit");
			System.out.println("1. Receptionist");
			System.out.println("2. Doctor");
			int userRole = scanner.nextInt();
			switch(userRole) {
				case 0:
					System.out.println("Quitting the program....");
					flag = false;
					scanner.close();
					break;
					
				case 1:
					ReceptionistUserMenu rum = new ReceptionistUserMenu(receptionist);
					rum.presentMenu(doc1, doc2, sur1, sur2, hospital);
					break;
					
				case 2:
					DoctorUserMenu dum = new DoctorUserMenu();
					dum.presentUserMenu(receptionist, doc1, doc2, sur1, sur2, hospital);
					break;
					
				default:
					scanner.close();
					try {
						throw new InvalidOperationNumberException();
					} catch (InvalidOperationNumberException e) {
						System.out.println("Invalid entry, try again.\n");
						continue;
					}
			}
		}
	}
}