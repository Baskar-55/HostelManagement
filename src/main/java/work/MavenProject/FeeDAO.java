package work.MavenProject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeeDAO {

    Connection con = DBConnection.getConnection();

    // INSERT FEE
    public void addFee(Fee fee) {

        String sql =
            "INSERT INTO fees " +
            "(fee_id, student_id, amount, payment_date, status) " +
            "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("❌ Database connection failed.");
                return;
            }

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, fee.getFeeId());
            ps.setInt(2, fee.getStudentId());
            ps.setDouble(3, fee.getAmount());
            ps.setDate(4, java.sql.Date.valueOf(fee.getPaymentDate()));
            ps.setString(5, fee.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Fee added successfully.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {

                System.out.println(
                    "❌ Fee ID already exists."
                );

            } else if (e.getErrorCode() == 1452) {

                System.out.println(
                    "❌ Student ID does not exist."
                );

            } else {

                System.out.println(
                    "❌ Unable to add fee."
                );
            }
        }
    }
    // VIEW FEES
    public void viewFees() {

        try {

            String sql = "SELECT * FROM fees";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println(
                "FEE_ID | STUDENT_ID | AMOUNT | DATE | STATUS"
            );

            System.out.println("-----------------------------------------------");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("fee_id") + " | " +
                    rs.getInt("student_id") + " | " +
                    rs.getDouble("amount") + " | " +
                    rs.getString("payment_date") + " | " +
                    rs.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // UPDATE STATUS
    public void updateFeeStatus(int feeId, String status) {

        try {

            String sql =
                "UPDATE fees SET status=? WHERE fee_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, feeId);

            int rows = ps.executeUpdate();

            System.out.println(
                rows > 0 ? "Updated Successfully" : "Update Failed"
            );

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // DELETE FEE
    public void deleteFee(int feeId) {

        try {

            String sql =
                "DELETE FROM fees WHERE fee_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, feeId);

            int rows = ps.executeUpdate();

            System.out.println(
                rows > 0 ? "Deleted Successfully" : "Delete Failed"
            );

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
 // VIEW UNPAID FEES
    public void viewUnpaidFees() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM fees WHERE status = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Pending");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== UNPAID FEES ==========");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                    "Fee ID: " + rs.getInt("fee_id") +
                    " | Student ID: " + rs.getInt("student_id") +
                    " | Amount: " + rs.getDouble("amount") +
                    " | Date: " + rs.getDate("payment_date") +
                    " | Status: " + rs.getString("status")
                );
            }

            if (!found) {

                System.out.println("No unpaid fees found.");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }
    }
}
