import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        Connection con = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Write Connection URL
            String url = "jdbc:postgresql://localhost:5432/Internship_day1";

            // 3. Connect
            con = DriverManager.getConnection(url, "postgres", "sadik@2005");

            // 4. Print Success Message
            System.out.println("Connected successfully!");

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }

        // 4. Close All Connections
        finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection Closed.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
