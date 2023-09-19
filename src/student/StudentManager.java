
package student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a Student Manager that manages a list of students.
 * It provides methods to save, search, delete, and retrieve student information.
 */
public class StudentManager {
    // List to store student objects
    private List<Student> students = new ArrayList<>(); 

    /**
     * Saves a student object to the list.
     *
     *The student to be saved.
     */
    public void saveStudent(Student student) {
        students.add(student);
    }

    /**
     * Searches for a student by their student ID.
     *
     *  The ID of the student to search for.
     * @return The found student object or null if not found.
     */
    public Student searchStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Deletes a student by their student ID.
     *
     * The ID of the student to be deleted.
     * @return true if the student was deleted, false if not found.
     */
    public boolean deleteStudent(String studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getStudentId().equals(studentId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a list of all students.
     *
     * @return List of all students.
     */
    public List<Student> getAllStudents() {
        return students;
    }
}
