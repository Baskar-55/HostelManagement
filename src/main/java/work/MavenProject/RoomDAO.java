package work.MavenProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDAO {

    Connection con = DBConnection.getConnection();

    // INSERT ROOM
    public void addRoom(Room room) {

        String sql =
            "INSERT INTO room(room_id, room_type, capacity, status) " +
            "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("❌ Database connection failed.");
                return;
            }

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, room.getRoomId());
            ps.setString(2, room.getRoomType());
            ps.setInt(3, room.getCapacity());
            ps.setString(4, room.getStatus());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Room added successfully.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {

                System.out.println(
                    "❌ Room ID already exists."
                );

            } else {

                System.out.println(
                    "❌ Unable to add room."
                );
            }
        }
    }
    // VIEW ALL ROOMS
    public void viewRooms() {
        try {
            String sql = "SELECT * FROM room";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getInt(3) + " | " +
                    rs.getString(4)
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // UPDATE ROOM STATUS
    public void updateRoomStatus(int roomId, String status) {
        try {
            String sql = "UPDATE room SET status=? WHERE room_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, roomId);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Updated Successfully" : "Update Failed");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // DELETE ROOM
    public void deleteRoom(int roomId) {
        try {
            String sql = "DELETE FROM room WHERE room_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, roomId);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Deleted Successfully" : "Delete Failed");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
 // VIEW AVAILABLE ROOMS
    public void viewAvailableRooms() {

        try {

            String sql = "SELECT * FROM room WHERE status = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Available");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== AVAILABLE ROOMS ==========");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                    "Room ID: " + rs.getInt("room_id") +
                    " | Type: " + rs.getString("room_type") +
                    " | Capacity: " + rs.getInt("capacity") +
                    " | Status: " + rs.getString("status")
                );
            }

            if (!found) {
                System.out.println("No available rooms found.");
            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }
    }
}