import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Connection URL (use your exact database name with capital I)
            String url = "jdbc:postgresql://localhost:5432/Internship_day1";

            // 3. Connect to Database
            con = DriverManager.getConnection(url, "postgres", "sadik@2005");

            // 4. Create Statement
            st = con.createStatement();

            // 5. INSERT Query as per your table
            String sql = "INSERT INTO students (id, name, email, dept_id) " +
                    "VALUES (11, 'Aman', 'aman@gmail.com', 101)";

            // 6. Execute Query
            st.executeUpdate(sql);

            System.out.println("Student data inserted successfully!");

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
