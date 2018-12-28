import java.util.List;
import java.util.Scanner;

public class TreatmentManagement {
	public void start() {
		Hospital<Patient> hospital = new Hospital<Patient>("Massachusetts General Hospital");
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
								throw new IllegalArgumentException("Invalid doctor.");
							}
							System.out.print("Please enter a date for the appointment (yyyy-mm-dd): ");
							String appointmentDate = scanner.nextLine();
							Date apDate = new Date(appointmentDate);
							receptionist.registerAPatient(doc, new Patient(hospital, patientName), apDate);
							
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
				System.out.println("Welcome " + "Dr. " + doctor.getLastName());
				boolean flag = true;
				while(flag) {
					System.out.println("Available Operations:");
					System.out.println("0. Exit Program");
					System.out.println("1. Today's Patients"); //exam 3
					System.out.println("2. List Patients Under Care");
					System.out.println("3. Search Analysis");
					System.out.println("4. List Examined Patients");
					System.out.println("5. Search An Examined Patient By Name"); //1
					System.out.println("6. Request Analysis");
					System.out.println("7. Write a prescription");
					System.out.println("8. Decide on surgery");
					System.out.println("9. Examine a Patient");
					int docOpNum = scanner.nextInt();
					switch(docOpNum) {
						
						case 0:
							flag = false;
							break;
						
						case 1:
							List<Appointment<Patient, Doctor>> todaysAps = receptionist.getAppointmentsOfDate(Date.getCurrentDate());
							for(Appointment<Patient, Doctor> ap: todaysAps) {
								if(!(ap.getDoctor().equals(doctor))) {
									todaysAps.remove(ap);
								}
							}
							
							for(Appointment<Patient, Doctor> nextAp: todaysAps) {
								System.out.println(nextAp.getPatient().toString());
							}
							
							break;
						
						case 2:
							List<Patient> patientsUnderCare = doctor.getAllPatientsUnderCare();
							for(Patient patient: patientsUnderCare) {
								System.out.println(patient.toString());
							}
							break;
						
						case 3:
							//
							break;
						
						case 4:
							List<Patient> examinedPatients = doctor.getAllExaminedPatients();
							for(Patient patient: examinedPatients) {
								System.out.println(patient.toString());
							}
							break;
						
						case 5:
							System.out.print("Please enter the name of the patient: ");
							String patientName = scanner.nextLine();
							Patient searchedPatient = doctor.searchAnExaminedPatient(patientName);
							Date examinationDate = searchedPatient.getExamination().getExaminationDate();
							System.out.println("Patient info: " + searchedPatient.toString());
							System.out.println("Examination date: " + examinationDate.toString());
							System.out.println("Patient type: " + searchedPatient.getClass());
							break;
							
						case 6:
							System.out.print("Please enter the patient's name: ");
							String name = scanner.nextLine();
							System.out.println("Please choose the type of analysis ");
							System.out.println("1. Blood Test Analysis");
							System.out.println("2. Radiology Analysis");
							System.out.println("3. Both");
							int testOp = scanner.nextInt();
							switch(testOp) {
								case 1:
									BloodTestAnalysis bta = doctor.requestBloodTest(doctor.searchAnExaminedPatient(name).getExamination());
									System.out.println("Blood test results: " + bta.toString());
									break;
								
								case 2:
									RadiologyAnalysis ra = doctor.requestRadiology(doctor.searchAnExaminedPatient(name).getExamination());
									System.out.println("Radiology test results: " + ra.toString());
									break;
									
								case 3:
									RadiologyAnalysis radiologyTest = doctor.requestRadiology(doctor.searchAnExaminedPatient(name).getExamination());
									BloodTestAnalysis bloodTest = doctor.requestBloodTest(doctor.searchAnExaminedPatient(name).getExamination());
									System.out.println("Blood Test Analysis Results:\n" + bloodTest.toString() + "\n");
									System.out.println("Radiology Analysis Results:\n" + radiologyTest.toString());
									break;
									
								default:
									//
									break;
							}
							break;
							
						case 7:
							System.out.print("Enter the patient's name here: ");
							String patientName2 = scanner.nextLine();
							Patient patient2 = doctor.searchAnExaminedPatient(patientName2);
							System.out.print("Enter the name of the medicine here: ");
							String medName = scanner.nextLine();
							System.out.print("Enter the dosage here: ");
							double medDosage = scanner.nextDouble();
							Prescription presc = new Prescription(medName, medDosage);
							System.out.print(presc.toString() + " has been prescribed.");
							break;
						case 8:
							System.out.print("Enter the patient's name here: ");
							String patientName3 = scanner.nextLine();
							System.out.print("Enter the surgeon's last name here: ");
							String surgeonName = scanner.nextLine();
							Doctor surgeon = null;
							if(surgeonName.equals("Strange")) {
								surgeon = sur1;
							} else if(surgeonName.equals("Turk")) {
								surgeon = sur2;
							}
							System.out.print("Please enter a date for the appointment (yyyy-mm-dd): ");
							String appointmentDate = scanner.nextLine();
							Date surgeryDate = new Date(appointmentDate);
							System.out.print("Please enter the number of days the patient will stay at the hospital for: ");
							int numberOfDays = scanner.nextInt();
							Appointment surgeryAppointment = new SurgeryAppointment(doctor.searchAnExaminedPatient(patientName3), surgeon, surgeryDate, numberOfDays);
							System.out.println("A surgery appointment has been created for " + patientName3 + " with Dr. " + surgeon.getLastName() + " as the surgeon.");
							System.out.println("Patient will go under surgery on " + surgeryDate.toString() + " and will stay at the hospital for " + numberOfDays + " days.");
					}
				}
				break;
				
			default:
				//invalid operation number
		}
		scanner.close();
	}
}