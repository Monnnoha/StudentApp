package main;

import model.College;
import service.StudentService;
import java.util.Scanner;
	
public class StudentApp {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		College obj = new College();
		StudentService service = new StudentService();
		boolean running = true;
		
		while(running) {
			System.out.println("=====Student Menu=====");
			System.out.println("1. Do you want enter any student details");
			System.out.println("2. Do you want any student details");
			System.out.println("3. Do you want to exit");
			System.out.println("Enter your choice:");
			
			String choiceInput =input.nextLine().trim();
			int choice =0;
			
			try {
				choice = Integer.parseInt(choiceInput);
			}
			catch(NumberFormatException e) {
				System.out.println("Enter a valid choice" + " "+   e);
				continue;
			}
			
			switch(choice) {
			case 1:
				College student = new College();
				
				System.out.print("Enter student name:");
				student.setName(input.nextLine().trim());
				
				long erp =0;
				while (true) {
					System.out.println("Enter student ERP number:");
					String erpInput= input.nextLine().trim();
					if(erpInput.isEmpty()) {
						System.out.println("Null value not accepted");
					}
					try {
						erp = Long.parseLong(erpInput);
						student.setErp(erp);
						break;
					}
					catch(Exception e) {
						System.out.println("Enter valid ERP number");
					}
				}
				System.out.print("Enter student Branch:");
				student.setBranch(input.nextLine().trim());
				
				System.out.print("Enter institute:");
				student.setInstitute(input.nextLine().trim());
				
				System.out.print("Enter college name:");
				student.setCname(input.nextLine().trim());
				
				service.addStudent(student);
				break;
				
				
				
				
			case 2:
				service.showAllStudents();
				break;
				
			case 3:
				System.out.println("Exiting the program...");
				running = false;
				break;
				
			default:
			    System.out.println("Invalid choice! Please try again.");
			    break;

			}
			
		}
		input.close();
	}

}
