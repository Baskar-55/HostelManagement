package work.MavenProject;

import java.util.Scanner;

public class FeeMain {

    public static void main(String[] args) {

        FeeDAO dao = new FeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== FEE MENU ===");
            System.out.println("1. Add Fee");
            System.out.println("2. View Fees");
            System.out.println("3. Update Fee Status");
            System.out.println("4. Delete Fee");
            System.out.println("5. Exit");

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
                    String date = sc.next();

                    System.out.print("Status: ");
                    String status = sc.next();

                    Fee fee =
                        new Fee(feeId, studentId, amount, date, status);

                    dao.addFee(fee);

                    break;

                case 2:

                    dao.viewFees();

                    break;

                case 3:

                    System.out.print("Fee ID: ");
                    int fid = sc.nextInt();

                    System.out.print("New Status: ");
                    String newStatus = sc.next();

                    dao.updateFeeStatus(fid, newStatus);

                    break;

                case 4:

                    System.out.print("Fee ID: ");
                    int did = sc.nextInt();

                    dao.deleteFee(did);

                    break;

                case 5:

                    System.exit(0);

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}