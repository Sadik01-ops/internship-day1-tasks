package week2.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// -----------------------------------------------
// Student Class
// -----------------------------------------------
class Student {
    private int id;
    private String name;
    private String course;

    // Constructor
    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    // toString() to print student details
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', course='" + course + "'}";
    }

    // equals() - defines when two Student objects are considered equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Student other = (Student) obj;
        return this.id == other.id;   // equal if ID is same
    }

    // hashCode() - MUST match equals()
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

// -----------------------------------------------
// MAIN CLASS
// -----------------------------------------------
public class StudentDuplicateRemoval {
    public static void main(String[] args) {

        // Create list with duplicates
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Aman", "Java"));
        students.add(new Student(2, "Neha", "Python"));
        students.add(new Student(3, "Rohit", "Java"));
        students.add(new Student(1, "Aman", "Java"));   // duplicate
        students.add(new Student(2, "Neha", "Python")); // duplicate
        students.add(new Student(4, "Sahil", "ML"));
        students.add(new Student(1, "Aman", "Java"));   // duplicate again

        // Print original list
        System.out.println("Original Student List:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Remove duplicates using HashSet
        Set<Student> uniqueStudents = new HashSet<>(students);

        // Print unique students
        System.out.println("\nUnique Students (After Removing Duplicates):");
        for (Student s : uniqueStudents) {
            System.out.println(s);
        }
    }
}
