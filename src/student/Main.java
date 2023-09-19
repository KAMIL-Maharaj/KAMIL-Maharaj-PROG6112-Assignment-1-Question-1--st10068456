package student;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a StudentManager to manage student records
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        // Display a welcome message and ask the user to press '1' to continue or any other key to exit
        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("****************************");
            System.out.println("ENTER (1) TO LAUNCH MENU OR ANY OTHER KEY TO EXIT");
            String input = scanner.nextLine();
            if (!input.equals("1")) {
                System.out.println("Exiting application. Goodbye!");
                break; // Exit the application
            }
            // Show the main menu to the user
            showMenu(studentManager, scanner);
        }
        scanner.close(); // Close the scanner when done
    }

    // Display the main menu and handle user choices
    private static void showMenu(StudentManager studentManager, Scanner scanner) {
        while (true) {
            System.out.println("PLEASE SELECT ONE OF THE FOLLOWING MENU ITEMS:");
            System.out.println("(1) Capture a new student");
            System.out.println("(2) Search for a student");
            System.out.println("(3) Delete a student");
            System.out.println("(4) Print student report");
            System.out.println("(5) Exit application");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Capture a new student's details
                    captureNewStudent(studentManager, scanner);
                    break;
                case "2":
                    // Search for a student by ID
                    searchStudent(studentManager, scanner);
                    break;
                case "3":
                    // Delete a student by ID
                    deleteStudent(studentManager, scanner);
                    break;
                case "4":
                    // Print a report of all students
                    printStudentReport(studentManager);
                    break;
                case "5":
                    // Exit the application
                    exitApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Capture a new student's details
    private static void captureNewStudent(StudentManager studentManager, Scanner scanner) {
        System.out.println("Capture a new student");
        System.out.println("*******************************");
        System.out.print("Enter the student id: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter the student name: ");
        String studentName = scanner.nextLine();
        int studentAge;
        while (true) {
            try {
                System.out.print("Enter the student age: ");
                studentAge = Integer.parseInt(scanner.nextLine());
                if (studentAge >= 16) {
                    break;
                } else {
                    System.out.println("You have entered an incorrect student age! Age must be 16 or greater.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid age.");
            }
        }
        System.out.print("Enter the student email: ");
        String studentEmail = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String studentCourse = scanner.nextLine();

        Student newStudent = new Student(studentId, studentName, studentAge, studentEmail, studentCourse);
        studentManager.saveStudent(newStudent);
        System.out.println("Student details have been successfully saved.");
    }

    // Search for a student by ID
    private static void searchStudent(StudentManager studentManager, Scanner scanner) {
        System.out.print("Enter the student id to search: ");
        String searchId = scanner.nextLine();

        Student foundStudent = studentManager.searchStudent(searchId);

        if (foundStudent != null) {
            // Display the found student's details
            System.out.println("------------------------------------");
            System.out.println("Student ID: " + foundStudent.getStudentId());
            System.out.println("Student Name: " + foundStudent.getStudentName());
            System.out.println("Student Age: " + foundStudent.getStudentAge());
            System.out.println("Student Email: " + foundStudent.getStudentEmail());
            System.out.println("Student Course: " + foundStudent.getStudentCourse());
            System.out.println("------------------------------------");
        } else {
            System.out.println("Student with student ID " + searchId + " not found.");
        }
    }

    // Delete a student by ID
    private static void deleteStudent(StudentManager studentManager, Scanner scanner) {
        System.out.print("Enter the student id to delete: ");
        String deleteId = scanner.nextLine();

        if (studentManager.deleteStudent(deleteId)) {
            System.out.println("Student with student ID " + deleteId + " was deleted.");
        } else {
            System.out.println("Student with student ID " + deleteId + " not found.");
        }
    }

    // Print a report of all students
    private static void printStudentReport(StudentManager studentManager) {
        List<Student> students = studentManager.getAllStudents();

        System.out.println("Student Report");
        System.out.println("----------------------------------");

        int studentCount = 1;
        for (Student student : students) {
            // Display each student's details
            System.out.println("Student " + studentCount);
            System.out.println("-------------------------------");
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Student Age: " + student.getStudentAge());
            System.out.println("Student Email: " + student.getStudentEmail());
            System.out.println("Student Course: " + student.getStudentCourse());
            System.out.println("----------------------------------");
            studentCount++;
        }
    }

    // Exit the application
    private static void exitApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0); // Terminate the program
    }
}
