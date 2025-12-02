import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateData {
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Connection URL
            String url = "jdbc:postgresql://localhost:5432/Internship_day1";

            // 3. Connect
            con = DriverManager.getConnection(url, "postgres", "sadik@2005");

            // 4. Create Statement
            st = con.createStatement();

            // 5. UPDATE Query (change name & email where id = 2)
            String sql = "UPDATE students SET name='Rohit', email='rohit@gmail.com' WHERE id=2";

            // 6. Execute UPDATE
            int rows = st.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Student data updated successfully!");
            } else {
                System.out.println("No student found with given ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 7. Close All Connections
        finally {
            try {
                if (st != null)
                    st.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
