package week2.day1.task1;

import java.util.ArrayList;

public class Student {

    private int id;
    private String name;
    private String course;

    // Static list to store students
    private static ArrayList<Student> studentList = new ArrayList<>();

    // Constructor
    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // ADD Student
    public static void addStudent(Student s) {
        studentList.add(s);
        System.out.println("Student added: " + s.name);
    }

    // SHOW all students
    public static void showStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // SEARCH student by ID
    public static Student searchStudent(int id) {
        for (Student s : studentList) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }

    // UPDATE student
    public static void updateStudent(int id, String newName, String newCourse) {
        Student s = searchStudent(id);

        if (s != null) {
            s.name = newName;
            s.course = newCourse;
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    // DELETE student
    public static void deleteStudent(int id) {
        Student s = searchStudent(id);

        if (s != null) {
            studentList.remove(s);
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    // toString
    @Override
    public String toString() {
        return "Student { id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                " }";
    }

    // MAIN method (testing)
    public static void main(String[] args) {

        addStudent(new Student(1, "Jack", "Java"));
        addStudent(new Student(2, "Emma", "Python"));

        System.out.println("\nAll Students:");
        showStudents();

        System.out.println("\nSearching ID = 1");
        System.out.println(searchStudent(1));

        System.out.println("\nUpdating ID = 2");
        updateStudent(2, "Emma Watson", "Spring Boot");

        System.out.println("\nAll Students After Update:");
        showStudents();

        System.out.println("\nDeleting ID = 1");
        deleteStudent(1);

        System.out.println("\nAll Students After Delete:");
        showStudents();
    }
}
