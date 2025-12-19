package week1;

import week1.task1.BankAccount;
import week1.task1.Employee;
import week1.task1.Student;

import week1.task2.EncapsulationDemo;
import week1.task2.StudentInherit;
import week1.task2.PersonWork;
import week1.task2.StudentPoly;
import week1.task2.EmployeePoly;
import week1.task2.Printable;
import week1.task2.StudentAbstract;

import week1.task3.StudentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {

        // ---------- PART A : OOP TESTING ----------
        System.out.println("----- OOP CLASSES TEST -----");

        Student s1 = new Student(1, "Faizan", 20, "Computer Science");
        s1.study();
        s1.attendClass();
        s1.displayInfo();

        Employee e1 = new Employee(101, "Ali", "IT", 25000);
        e1.work();
        e1.displayInfo();

        BankAccount b1 = new BankAccount(12345, "Faizan", 5000, "SBI");
        b1.deposit(1000);
        b1.checkBalance();

        // =================================================
        // ---------- PART B : OOP PILLARS ----------
        System.out.println("\n----- OOP PILLARS TEST -----");

        // Encapsulation
        EncapsulationDemo enc = new EncapsulationDemo();
        enc.setName("Faizan");
        System.out.println("Encapsulation Name: " + enc.getName());

        // Inheritance
        StudentInherit si = new StudentInherit();
        si.setPname("Faizan");
        si.setAge(20);
        si.setCourse("Computer Science");
        si.showDetails();
        si.study();

        // Polymorphism
        PersonWork p1 = new StudentPoly();
        PersonWork p2 = new EmployeePoly();
        p1.work();
        p2.work();

        // Abstraction
        Printable p = new StudentAbstract();
        p.printDetails();

        // =================================================
        // ---------- PART C : JDBC CONNECTION ----------
        System.out.println("\n----- JDBC CONNECTION TEST -----");

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/internship_day1";
            String user = "postgres";
            String password = "Admin@12345";

            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");

            stmt = con.createStatement();

            // =================================================
            // ---------- PART C : JDBC CRUD ----------
            System.out.println("\n----- JDBC CRUD OPERATIONS -----");

            StudentDAO dao = new StudentDAO(con);

            // INSERT
            dao.insertStudent("Faizan", 20);
            dao.insertStudent("Ali", 22);

            // SELECT
            System.out.println("All Students:");
            dao.getAllStudents();

            // UPDATE
            dao.updateStudent(1, "Ahmed");

            // DELETE
            dao.deleteStudent(2);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();

                System.out.println("All connections closed successfully.");
            } catch (Exception e) {
                System.out.println("Close error: " + e.getMessage());
            }
        }
    }
}