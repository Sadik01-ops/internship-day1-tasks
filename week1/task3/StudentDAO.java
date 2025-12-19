package week1.task3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {

    Connection con;

    // Constructor receives connection
    public StudentDAO(Connection con) {
        this.con = con;
    }

    public void insertStudent(String name, int age) throws Exception {

        String query = "INSERT INTO students(name, age) VALUES (?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, age);

        ps.executeUpdate();
        System.out.println("Inserted Successfully");
    }


    public void getAllStudents() throws Exception {

        String query = "SELECT * FROM students";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getInt("age")
            );
        }
    }

    public void updateStudent(int id, String newName) throws Exception {

        String query = "UPDATE students SET name = ? WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, newName);
        ps.setInt(2, id);

        ps.executeUpdate();
        System.out.println("Updated Successfully");
    }

    public void deleteStudent(int id) throws Exception {

        String query = "DELETE FROM students WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        ps.executeUpdate();
        System.out.println("Deleted Successfully");
    }
}