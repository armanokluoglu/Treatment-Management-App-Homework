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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Massachusetts General Hospital Management Program");
		System.out.println("Please select your role:");
		System.out.println("1. Receptionist");
		System.out.println("2. Doctor");
		int userRole = scanner.nextInt();
		switch(userRole) {
			case 1:
				System.out.println("Receptionists:");
				System.out.println("1. " + receptionist.fullName);
				int receptionistUser = scanner.nextInt();
				if(receptionistUser == 1) {
					System.out.println("Welcome " + receptionist.fullName);
					while(true) {
						System.out.println("Available Operations:");
						System.out.println("0. Exit Program");
						System.out.println("1. Register Patient");
						int recOpNum = scanner.nextInt();
						if(recOpNum == 1) {
							System.out.println("Enter the name of the patient (ex: Chris Pine)");
							String patientName = scanner.nextLine();
							//register patient
						} else if(recOpNum == 0) {
							break;
						} else {
							//invalid operation number
						}
					}
				} else {
					//invalid operation number
				}
				break;
			case 2:
				System.out.println("Doctors:");
				System.out.println("1. " + doc1.toString());
				System.out.println("2. " + doc2.toString());
				System.out.println("3. " + sur1.toString());
				System.out.println("4. " + sur2.toString());
				int doctorUser = scanner.nextInt();
				Doctor doctor = null;
				switch(doctorUser) {
					case 1:
						doctor = doc1;
						break;
					case 2:
						doctor = doc2;
						break;
					case 3:
						doctor = sur1;
						break;
					case 4:
						doctor = sur2;
						break;
					default:
						//invalid operation number
				}
				System.out.println("Welcome " + "Dr. " + doctor.lastName);
				boolean flag = true;
				while(flag) {
					System.out.println("Available Operations:");
					System.out.println("0. Exit Program");
					System.out.println("1. Today's Patients"); //exam 3
					System.out.println("2. List Patients");
					System.out.println("3. Search Analysis");
					System.out.println("4. List Examined Patients");
					System.out.println("5. Search Examined Patient"); //1
					int docOpNum = scanner.nextInt();
					switch(docOpNum) {
						case 0:
							flag = false;
							break;
						case 1:
							//
							break;
						case 2:
							//
							break;
						case 3:
							//
							break;
						case 4:
							//
							break;
						case 5:
							//
							break;
					}
				}
				break;
			default:
				//invalid operation number
		}
	}
}