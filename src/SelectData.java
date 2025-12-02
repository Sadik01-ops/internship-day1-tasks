import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectData {
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Connection URL
            String url = "jdbc:postgresql://localhost:5432/Internship_day1";

            // 3. Connect
            con = DriverManager.getConnection(url, "postgres", "sadik@2005");

            // 4. Create Statement
            st = con.createStatement();

            // 5. SELECT Query
            String sql = "SELECT * FROM students";

            // 6. Execute Query
            rs = st.executeQuery(sql);

            // 7. Display Data
            System.out.println("ID\tName\tEmail\t\t\tDept_ID");
            System.out.println("---------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int deptId = rs.getInt("dept_id");

                System.out.println(id + "\t" + name + "\t" + email + "\t" + deptId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 8. Close All Connections (As per your objective)
        finally {
            try {
                if (rs != null)
                    rs.close();
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
