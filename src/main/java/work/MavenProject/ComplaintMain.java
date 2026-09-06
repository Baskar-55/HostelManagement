package work.MavenProject;

import java.util.Scanner;

public class ComplaintMain {

    public static void main(String[] args) {

        ComplaintDAO dao = new ComplaintDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== COMPLAINT MENU ===");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Update Complaint Status");
            System.out.println("4. Delete Complaint");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Complaint ID: ");
                    int complaintId = sc.nextInt();

                    System.out.print("Student ID: ");
                    int studentId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Complaint: ");
                    String complaint = sc.nextLine();

                    System.out.print("Complaint Date (YYYY-MM-DD): ");
                    String date = sc.next();

                    System.out.print("Status: ");
                    String status = sc.next();

                    Complaint c =
                        new Complaint(
                            complaintId,
                            studentId,
                            complaint,
                            date,
                            status
                        );

                    dao.addComplaint(c);

                    break;

                case 2:

                    dao.viewComplaints();

                    break;

                case 3:

                    System.out.print("Complaint ID: ");
                    int cid = sc.nextInt();

                    System.out.print("New Status: ");
                    String newStatus = sc.next();

                    dao.updateComplaintStatus(cid, newStatus);

                    break;

                case 4:

                    System.out.print("Complaint ID: ");
                    int did = sc.nextInt();

                    dao.deleteComplaint(did);

                    break;

                case 5:

                    System.exit(0);

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}