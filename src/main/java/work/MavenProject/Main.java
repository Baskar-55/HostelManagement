package work.MavenProject;

import java.util.Scanner;

public class Main {

    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // FIRST: ADMIN LOGIN
        if (!adminLogin(sc)) {
            System.out.println("Login Failed!");
            System.out.println("Program Closed.");
            sc.close();
            return;
        }

        // AFTER LOGIN: SHOW MAIN MENU
        while (true) {

            System.out.println("\n======================================");
            System.out.println("       HOSTEL MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Student Management");
            System.out.println("2. Room Management");
            System.out.println("3. Fee Management");
            System.out.println("4. Complaint Management");
            System.out.println("5. Logout");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    studentMenu(sc);
                    break;

                case 2:
                    roomMenu(sc);
                    break;

                case 3:
                    feeMenu(sc);
                    break;

                case 4:
                    complaintMenu(sc);
                    break;

                case 5:
                    System.out.println("Admin Logged Out!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    // =====================================================
    // ADMIN LOGIN
    // =====================================================

    public static boolean adminLogin(Scanner sc) {

        AdminDAO dao = new AdminDAO();

        System.out.println("\n======================================");
        System.out.println("           ADMIN LOGIN");
        System.out.println("======================================");

        System.out.print("Username: ");
        String username = sc.next();

        System.out.print("Password: ");
        String password = sc.next();

        boolean result = dao.login(username, password);

        if (result) {

            System.out.println("\nLogin Successful!");
            System.out.println("Welcome Admin!");

            return true;

        } else {

            System.out.println("\nInvalid Username or Password!");

            return false;
        }
    }


    // =====================================================
    // STUDENT MENU
    // =====================================================

    public static void studentMenu(Scanner sc) {

        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n========== STUDENT MENU ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Phone");
            System.out.println("5. Delete Student");
            System.out.println("6. Back");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
            case 1:

                System.out.print("Student ID: ");
                int id = sc.nextInt();

                System.out.print("Name: ");
                String name = sc.next();

                System.out.print("Phone: ");
                String phone = sc.next();

                System.out.print("Course: ");
                String course = sc.next();

                Student student =
                        new Student(id, name, phone, course);

                dao.addStudent(student);

                break;               
                case 2:

                    dao.viewStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    int searchId = sc.nextInt();

                    dao.searchStudentById(searchId);

                    break;
                case 4:

                    System.out.print("Student ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("New Phone: ");
                    String newPhone = sc.next();

                    dao.updateStudentPhone(updateId, newPhone);

                    break;


                case 5:

                    System.out.print("Student ID: ");
                    int deleteId = sc.nextInt();

                    dao.deleteStudent(deleteId);

                    break;


                case 6:

                    return;

                default:

                    System.out.println("Invalid choice!");
            }
        }
    }


    // =====================================================
    // ROOM MENU
    // =====================================================

    public static void roomMenu(Scanner sc) {

        RoomDAO dao = new RoomDAO();

        while (true) {

            System.out.println("\n========== ROOM MENU ==========");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Update Room Status");
            System.out.println("4. Delete Room");
            System.out.println("5. View Available Rooms");
            System.out.println("6. Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Room ID: ");
                    int roomId = sc.nextInt();

                    System.out.print("Room Type: ");
                    String roomType = sc.next();

                    System.out.print("Capacity: ");
                    int capacity = sc.nextInt();

                    System.out.print("Status: ");
                    String status = sc.next();

                    Room room =
                            new Room(
                                    roomId,
                                    roomType,
                                    capacity,
                                    status
                            );

                    dao.addRoom(room);

                    break;

                case 2:

                    dao.viewRooms();

                    break;

                case 3:

                    System.out.print("Room ID: ");
                    int updateRoomId = sc.nextInt();

                    System.out.print("New Status: ");
                    String newStatus = sc.next();

                    dao.updateRoomStatus(
                            updateRoomId,
                            newStatus
                    );

                    break;

                case 4:

                    System.out.print("Room ID: ");
                    int deleteRoomId = sc.nextInt();

                    dao.deleteRoom(deleteRoomId);

                    break;

                case 5:

                    dao.viewAvailableRooms();

                    break;

                case 6:

                    return;
                default:

                    System.out.println("Invalid choice!");
            }
        }
    }


    // =====================================================
    // FEE MENU
    // =====================================================

    public static void feeMenu(Scanner sc) {

        FeeDAO dao = new FeeDAO();

        while (true) {

            System.out.println("\n========== FEE MENU ==========");
            System.out.println("1. Add Fee");
            System.out.println("2. View Fees");
            System.out.println("3. View Unpaid Fees");
            System.out.println("4. Update Fee Status");
            System.out.println("5. Delete Fee");
            System.out.println("6. Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Fee ID: ");
                    int feeId = sc.nextInt();

                    System.out.print("Student ID: ");
                    int studentId = sc.nextInt();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    System.out.print("Payment Date (YYYY-MM-DD): ");
                    String paymentDate = sc.next();

                    System.out.print("Status: ");
                    String feeStatus = sc.next();

                    Fee fee =
                            new Fee(
                                    feeId,
                                    studentId,
                                    amount,
                                    paymentDate,
                                    feeStatus
                            );

                    dao.addFee(fee);

                    break;

                case 2:

                    dao.viewFees();

                    break;

                case 3:

                    dao.viewUnpaidFees();

                    break;
                case 4:

                    System.out.print("Fee ID: ");
                    int updateFeeId = sc.nextInt();

                    System.out.print("New Status: ");
                    String newFeeStatus = sc.next();

                    dao.updateFeeStatus(updateFeeId, newFeeStatus);

                    break;


                case 5:

                    System.out.print("Fee ID: ");
                    int deleteFeeId = sc.nextInt();

                    dao.deleteFee(deleteFeeId);

                    break;


                case 6:

                    return;
                default:

                    System.out.println("Invalid choice!");
            }
        }
     
    }


    // =====================================================
    // COMPLAINT MENU
    // =====================================================

    public static void complaintMenu(Scanner sc) {

        ComplaintDAO dao = new ComplaintDAO();

        while (true) {

            System.out.println("\n========== COMPLAINT MENU ==========");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. View Pending Complaints");
            System.out.println("4. Update Complaint Status");
            System.out.println("5. Delete Complaint");
            System.out.println("6. Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Complaint ID: ");
                    int complaintId = sc.nextInt();

                    System.out.print("Student ID: ");
                    int complaintStudentId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Complaint: ");
                    String complaint = sc.nextLine();

                    System.out.print(
                            "Complaint Date (YYYY-MM-DD): "
                    );

                    String complaintDate = sc.next();

                    System.out.print("Status: ");
                    String complaintStatus = sc.next();

                    Complaint c =
                            new Complaint(
                                    complaintId,
                                    complaintStudentId,
                                    complaint,
                                    complaintDate,
                                    complaintStatus
                            );

                    dao.addComplaint(c);

                    break;

                case 2:

                    dao.viewComplaints();

                    break;

                case 3:

                    dao.viewPendingComplaints();

                    break;
                case 4:

                    System.out.print("Complaint ID: ");
                    int updateComplaintId = sc.nextInt();

                    System.out.print("New Status: ");
                    String newComplaintStatus = sc.next();

                    dao.updateComplaintStatus(
                        updateComplaintId,
                        newComplaintStatus
                    );

                    break;


                case 5:

                    System.out.print("Complaint ID: ");
                    int deleteComplaintId = sc.nextInt();

                    dao.deleteComplaint(deleteComplaintId);

                    break;


                case 6:

                    return;
                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}