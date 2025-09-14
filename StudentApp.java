package main;

import model.College;
import model.Student.Branch;
import service.StudentService;
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentService service = new StudentService();
        boolean running = true;

        while (running) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Show All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.println("========================");
            System.out.print("Enter your choice: ");

            String choiceInput = input.nextLine().trim();
            int choice = 0;

            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid choice " + e);
                continue;
            }

            switch (choice) {
                case 1:
                    College student = new College();

                    String name;
                    while(true) {
                    	System.out.println("Enter you name: ");
                    	name = input.nextLine().trim();
                    	if(name.isEmpty()) {
                    		System.out.println("Name cannot be empty");
                    		continue;
                    	}
                    	if(!name.matches("[a-zA-Z ]+")) {
                    		System.out.println("Name should contain only alphabets and spaces");
                    		continue;
                    	}
                    	if(name.length() <2 || name.length() >30) {
                    		System.out.println("Name should be between 2 to 30 characters	");
                    		continue;
                    	}
                    	break;
                    }
                    student.setName(name);
                    long erp = 0;
                    while (true) {
                        System.out.print("Enter student ERP number: ");
                        String erpInput = input.nextLine().trim();
                        if (erpInput.isEmpty()) {
                            System.out.println("Null value not accepted");
                            continue;
                        }
                        try {
                            erp = Long.parseLong(erpInput);
                            student.setErp(erp);
                            break;
                        } catch (Exception e) {
                            System.out.println("Enter valid ERP number");
                        }
                    }
                    
                   Branch branch = null;
                   while(true) {
                	   System.out.println("Enter student branch: ");
                	   String branchInput =input.nextLine().trim().toUpperCase();
                	   try {
                		   branch = branch.valueOf(branchInput);
                		   break;
                	   }
                	   catch(IllegalArgumentException e) {
                		   System.out.println("Invalid branch! please enter course related branch names");
                	   }
                   }
                   student.setBranch(branch);

                    System.out.print("Enter institute: ");
                    student.setInstitute(input.nextLine().trim());

                    System.out.print("Enter college name: ");
                    student.setCname(input.nextLine().trim());

                    service.addStudent(student);
                    break;

                case 2:
                    service.showAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ERP number to search: ");
                    long erpToSearch = Long.parseLong(input.nextLine().trim());
                    service.searchStudent(erpToSearch);
                    break;

                case 4:
                    System.out.print("Enter the ERP number you want to delete: ");
                    long erpToDelete = Long.parseLong(input.nextLine().trim());
                    service.deleteStudent(erpToDelete);
                    break;

                case 5:
                	System.out.println("Enter the student ERP number you want to update: ");
                	long erpToUpdate = Long.parseLong(input.nextLine().trim());
                	service.updateStudent(erpToUpdate);
                	break;

                case 6:
                    System.out.println("Exiting the program.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }
}
