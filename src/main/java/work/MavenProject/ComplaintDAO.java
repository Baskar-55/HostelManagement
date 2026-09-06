package work.MavenProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComplaintDAO {

    Connection con = DBConnection.getConnection();

    // INSERT COMPLAINT
    public void addComplaint(Complaint complaint) {

        try {

            String sql = "INSERT INTO complaints " +
                         "(complaint_id, student_id, complaint, " +
                         "complaint_date, status) " +
                         "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, complaint.getComplaintId());
            ps.setInt(2, complaint.getStudentId());
            ps.setString(3, complaint.getComplaint());
            ps.setString(4, complaint.getComplaintDate());
            ps.setString(5, complaint.getStatus());

            int rows = ps.executeUpdate();

            System.out.println(
                rows > 0 ? "Complaint Added Successfully"
                         : "Insert Failed"
            );

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {
                System.out.println("❌ Complaint ID already exists.");

            } else if (e.getErrorCode() == 1452) {
                System.out.println("❌ Student ID does not exist.");

            } else {
                System.out.println("❌ Unable to add complaint.");
            }
        }
    }    

    // VIEW COMPLAINTS
    public void viewComplaints() {

        try {

            String sql = "SELECT * FROM complaints";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println(
                "ID | STUDENT_ID | COMPLAINT | DATE | STATUS"
            );

            System.out.println("-----------------------------------------------");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("complaint_id") + " | " +
                    rs.getInt("student_id") + " | " +
                    rs.getString("complaint") + " | " +
                    rs.getString("complaint_date") + " | " +
                    rs.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // UPDATE STATUS
    public void updateComplaintStatus(int complaintId, String status) {

        try {

            String sql =
                "UPDATE complaints SET status=? WHERE complaint_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, complaintId);

            int rows = ps.executeUpdate();

            System.out.println(
                rows > 0 ? "Updated Successfully" : "Update Failed"
            );

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // DELETE COMPLAINT
    public void deleteComplaint(int complaintId) {

        try {

            String sql =
                "DELETE FROM complaints WHERE complaint_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, complaintId);

            int rows = ps.executeUpdate();

            System.out.println(
                rows > 0 ? "Deleted Successfully" : "Delete Failed"
            );

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
 // VIEW PENDING COMPLAINTS
    public void viewPendingComplaints() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM complaints WHERE status = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Pending");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== PENDING COMPLAINTS ==========");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                    "Complaint ID: " + rs.getInt("complaint_id") +
                    " | Student ID: " + rs.getInt("student_id") +
                    " | Complaint: " + rs.getString("complaint") +
                    " | Date: " + rs.getDate("complaint_date") +
                    " | Status: " + rs.getString("status")
                );
            }

            if (!found) {

                System.out.println("No pending complaints found.");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }
    }
}
