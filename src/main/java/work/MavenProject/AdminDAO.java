package work.MavenProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    Connection con = DBConnection.getConnection();

    // ADMIN LOGIN
    public boolean login(String username, String password) {

        try {

            String sql =
                "SELECT * FROM admin " +
                "WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return false;
    }
}