/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package student;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author kamil
 */
public class StudentManagerTest {
    
  private StudentManager studentManager;

    @Before
    public void setUp() {
        studentManager = new StudentManager();
    }

    @Test
    public void testSaveAndSearchStudent() {
        Student student = new Student("1", "kamil maharaj", 18, "kamilmaharaj222@gmail.com", "Computer Science");
        studentManager.saveStudent(student);
        
        Student foundStudent = studentManager.searchStudent("1");
        assertNotNull(foundStudent);
        assertEquals("kamil maharaj", foundStudent.getStudentName());
    }

    @Test
    public void testSearchStudent_StudentNotFound() {
        Student foundStudent = studentManager.searchStudent("2");
        assertNull(foundStudent);
    }

    @Test
    public void testDeleteStudent() {
        Student student = new Student("3", "Alice Johnson", 22, "alice11@gmail.com", "Physics");
        studentManager.saveStudent(student);

        boolean deleted = studentManager.deleteStudent("3");
        assertTrue(deleted);

        Student deletedStudent = studentManager.searchStudent("3");
        assertNull(deletedStudent);
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        boolean deleted = studentManager.deleteStudent("4");
        assertFalse(deleted);
    }

    @Test
    public void testStudentAge_StudentAgeValid() {
        Student student = new Student("5", "Bob Brown", 19, "bob@@gmail.com", "History");
        studentManager.saveStudent(student);

        Student foundStudent = studentManager.searchStudent("5");
        assertNotNull(foundStudent);
        assertEquals(19, foundStudent.getStudentAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStudentAge_StudentAgeInvalid() {
        Student student = new Student("6", "neha seebran", 16, "seebran@@gmail.com", "Chemistry");
        studentManager.saveStudent(student);
    }

    @Test(expected = NumberFormatException.class)
    public void testStudentAge_StudentAgeInvalidCharacter() {
        Student student = new Student("7", "kamil", Integer.parseInt("kmi"), "kamil@.com", "it");
        studentManager.saveStudent(student);
    }
}

