package work.MavenProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

    Connection con = DBConnection.getConnection();

    // INSERT STUDENT
    public void addStudent(Student student) {

        String sql =
            "INSERT INTO Student(id, name, phone, course) " +
            "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("❌ Database connection failed.");
                return;
            }

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getCourse());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Student added successfully.");
            }

            ps.close();
            con.close();

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {
                System.out.println("❌ Student ID already exists.");
            } else {
                System.out.println("❌ Unable to add student.");
            }
        }
    }

    // VIEW STUDENTS
    public void viewStudents() {
        try {
            String sql = "SELECT * FROM Student";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("ID | NAME | PHONE | COURSE");
            System.out.println("--------------------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("phone") + " | " +
                    rs.getString("course")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // UPDATE PHONE
    public void updateStudentPhone(int id, String phone) {
        try {
            String sql = "UPDATE Student SET phone=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, phone);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            System.out.println(
                rows > 0 ? "Updated Successfully" : "Update Failed"
            );

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {
        try {
            String sql = "DELETE FROM Student WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            System.out.println(
                rows > 0 ? "Deleted Successfully" : "Delete Failed"
            );

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
 // SEARCH STUDENT BY ID
    public void searchStudentById(int studentId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM Student WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n========== STUDENT DETAILS ==========");

                System.out.println("ID     : " + rs.getInt("id"));
                System.out.println("Name   : " + rs.getString("name"));
                System.out.println("Phone  : " + rs.getString("phone"));
                System.out.println("Course : " + rs.getString("course"));

            } else {

                System.out.println("Student not found!");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }
    }
}