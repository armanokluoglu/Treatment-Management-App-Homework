import java.util.List;
import java.util.Scanner;

public class DoctorUserMenu {

	private Scanner scanner;
	
	public DoctorUserMenu() {
		scanner = new Scanner(System.in);
	}
	
	
	private void checkForSurgeriesOfToday(Receptionist receptionist, Surgeon sur1, Surgeon sur2) {
		SurgeryAppointment sa = receptionist.getSurgeryAppointmentForSurgeon(sur1);
		Patient patientForSurgery = receptionist.getSurgeryAppointmentForSurgeon(sur1).getPatient();
		SurgeryAppointment sa_2 = receptionist.getSurgeryAppointmentForSurgeon(sur2);
		Patient patientForSurgery_2 = receptionist.getSurgeryAppointmentForSurgeon(sur2).getPatient();
		if(sa.getAppointmentDate() == Date.getCurrentDate()) {
			sur1.startSurgeryOnPatient(patientForSurgery);
			patientForSurgery = new InmatePatient(patientForSurgery); //After the surgery, make patients inmate patients.
		}
		if(sa_2.getAppointmentDate() == Date.getCurrentDate()) {
			sur2.startSurgeryOnPatient(patientForSurgery_2);
			patientForSurgery_2 = new InmatePatient(patientForSurgery_2); //After the surgery, make patients inmate patients.
		}
	}
	
	
	private void listTodaysAppointments(Receptionist receptionist, Doctor doctor) {
		List<Appointment<Patient, Doctor>> todaysAps = receptionist.getAppointmentsOfDate(Date.getCurrentDate());
		for(Appointment<Patient, Doctor> ap: todaysAps) {
			if(!(ap.getDoctor().equals(doctor))) {
				todaysAps.remove(ap);
			}
		}
		System.out.println("Listing today's patients...");
		for(Appointment<Patient, Doctor> nextAp: todaysAps) {
			System.out.println(nextAp.getPatient().toString());
		}
	}
	
	
	private void listPatientsUnderCare(Doctor doctor) {
		List<Patient> patientsUnderCare = doctor.getAllPatientsUnderCare();
		System.out.println("Listing patients under care...");
		for(Patient patient: patientsUnderCare) {
			System.out.println(patient.toString());
		}
	}
	
	
	private void searchAnalysis(Hospital hospital) {
		System.out.println("Please enter the patient's full name: ");
		String patientName = scanner.nextLine();
		Analysis foundAnalysis = hospital.searchAnalysis(patientName);
		System.out.println("Searched analysis is found!");
		System.out.println(foundAnalysis.toString());
	}
	
	
	private void listExaminedPatients(Doctor doctor) {
		List<Patient> examinedPatients = doctor.getAllExaminedPatients();
		for(Patient patient: examinedPatients) {
			System.out.println(patient.toString());
		}
	}
	
	private void searchAnExaminedPatient(Doctor doctor) {
		System.out.print("Please enter the full name of patient: ");
		String patientsName = scanner.nextLine();
		Patient searchedPatient = doctor.searchAnExaminedPatient(patientsName);
		Date examinationDate = searchedPatient.getExamination().getExaminationDate();
		System.out.println("Getting the patient info....");
		System.out.println("Patient info: " + searchedPatient.toString());
		System.out.println("Examination date: " + examinationDate.toString());
		System.out.println("Patient type: " + searchedPatient.getClass());
	}
	
	
	private void writeAPrescription(Doctor doctor) {
		System.out.print("Enter patient's name here: ");
		String patientName2 = scanner.nextLine();
		doctor.searchAnExaminedPatient(patientName2); //In case of such patient does not exist
		System.out.print("Enter name of the medicine here: ");
		String medName = scanner.nextLine();
		System.out.print("Enter the dosage here: ");
		double medDosage = scanner.nextDouble();
		Prescription presc = doctor.writeAPrescription(medName, medDosage);
		System.out.print(presc.toString() + " has been prescribed.");
	}
	
	private void requestAnalysis(Doctor doctor) {
		System.out.print("Please enter the patient's name: ");
		String name = scanner.nextLine();
		if(!doctor.searchAnExaminedPatient(name).isExamined()) {
			try {
				throw new AnalysisNotFoundException();
			} catch (AnalysisNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	}
	
	
	private void decideOnASurgery(Doctor sur1, Doctor sur2, Receptionist receptionist, Doctor doctor) {
		System.out.print("Enter the patient's full name here: ");
		String patientName3 = scanner.nextLine();
		Patient patientForSurgery = doctor.searchAnExaminedPatient(patientName3);
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
		Appointment<Patient, Doctor> surgeryAppointment = new SurgeryAppointment(doctor.searchAnExaminedPatient(patientName3), surgeon, surgeryDate, numberOfDays);
		receptionist.registerAPatient(surgeon, patientForSurgery, surgeryAppointment.getAppointmentDate());
		System.out.println("A surgery appointment has been created for " + patientName3 + " with Dr. " + surgeon.getLastName() + " as the surgeon.");
		System.out.println("Patient will go under surgery on " + surgeryDate.toString() + " and will stay at the hospital for " + numberOfDays + " days.");
		doctor.addAPatientUnderCare(patientForSurgery);
		Surgery surgery = new Surgery((Surgeon)surgeon, patientForSurgery);
		if(surgeryDate == Date.getCurrentDate()) {
			surgery.startTreatment();
		}
	}
	
	
	private void examineAPatient(Doctor doctor, Receptionist receptionist) {
		int patientIndex = 0;
		List<Appointment<Patient, Doctor>> todaysAppointments = receptionist.getAppointmentsOfDate(Date.getCurrentDate());
		for(Appointment<Patient, Doctor> ap: todaysAppointments) {
			if(!(ap.getDoctor().equals(doctor))) {
				todaysAppointments.remove(ap);
			}
		}
		for(Appointment<Patient, Doctor> nextAp: todaysAppointments) {
			System.out.println(patientIndex + 1 + ". " + nextAp.getPatient().getFullName());
		}
		System.out.print("Please choose a patient to examine.");
		int patientNumber = scanner.nextInt();
		Patient patientToExamine = todaysAppointments.get(patientNumber-1).getPatient();
		doctor.examine(patientToExamine);
		System.out.println("Patient is examined.");
	}
	
	public void presentUserMenu(Receptionist receptionist, Doctor doc1, Doctor doc2, Doctor sur1, Doctor sur2, Hospital hospital) {
		
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
				scanner.close();
				throw new IllegalArgumentException("Invalid operation number.");
		}
		System.out.println("Welcome " + "Dr. " + doctor.getLastName());
		boolean flag = true;
		while(flag) {
			checkForSurgeriesOfToday(receptionist, (Surgeon)sur1, (Surgeon)sur2); // If there are any surgeries assigned for surgeon1 or surgeon2, get them done.
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
					//Quit the program.
					System.out.println("Quitting the program....");
					flag = false;
					break;
				
				case 1:
					//List today's appointments (patients)
					listTodaysAppointments(receptionist, doctor);
					break;
				
				case 2:
					//List patients under care.
					listPatientsUnderCare(doctor);
					break;
				
				case 3:
					//Search an analysis.
					searchAnalysis(hospital);
					break;
				
				case 4:
					//List examined patients.
					listExaminedPatients(doctor);
					break;
				
				case 5:
					//Search an examined patient.
					searchAnExaminedPatient(doctor);
					break;
					
				case 6:
					//Request Analysis
					requestAnalysis(doctor);
					break;
					
				case 7:
					//Write a prescription
					writeAPrescription(doctor);
					break;
					
				case 8:
					//Decide on a surgery.
					decideOnASurgery(sur1, sur2, receptionist, doctor);
					break;
					
				case 9:
					//Examining a patient.
					examineAPatient(doctor, receptionist);
					break;
					
			}
		}
	}
}