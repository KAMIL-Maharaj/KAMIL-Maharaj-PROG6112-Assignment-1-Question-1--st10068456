// Importing the Scanner class for user input
package student;

import java.util.Scanner;

// Defining the Student class
class Student {
    
    // Class attributes or member variables
    
    // Unique identifier for the student
    private String studentId;
    
    // Name of the student
    private String studentName;
    
    // Age of the student
    private int studentAge;
    
    // Email address of the student
    private String studentEmail;
    
    // Course in which the student is enrolled
    private String studentCourse;

    // Constructor to initialize the student object with details
    public Student(String studentId, String studentName, int studentAge, String studentEmail, String studentCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentCourse = studentCourse;
    }

    // Getter method to retrieve the student's ID
    public String getStudentId() {
        return studentId;
    }

    // Getter method to retrieve the student's name
    public String getStudentName() {
        return studentName;
    }

    // Getter method to retrieve the student's age
    public int getStudentAge() {
        return studentAge;
    }

    // Getter method to retrieve the student's email
    public String getStudentEmail() {
        return studentEmail;
    }

    // Getter method to retrieve the student's course
    public String getStudentCourse() {
        return studentCourse;
    }
}
