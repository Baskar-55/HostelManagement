package work.MavenProject;



import java.util.Scanner;

public class InputValidator {

    // Read positive integer
    public static int getPositiveInt(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            if (sc.hasNextInt()) {

                int value = sc.nextInt();

                if (value > 0) {
                    return value;
                }

                System.out.println("❌ Enter a number greater than 0.");

            } else {

                System.out.println("❌ Please enter a valid number.");
                sc.next();
            }
        }
    }


    // Read positive double
    public static double getPositiveDouble(Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            if (sc.hasNextDouble()) {

                double value = sc.nextDouble();

                if (value > 0) {
                    return value;
                }

                System.out.println("❌ Amount must be greater than 0.");

            } else {

                System.out.println("❌ Please enter a valid amount.");
                sc.next();
            }
        }
    }


    // Read non-empty string
    public static String getNonEmptyString(
            Scanner sc, String message) {

        while (true) {

            System.out.print(message);

            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("❌ This field cannot be empty.");
        }
    }


    // Read phone number
    public static String getPhone(Scanner sc) {

        while (true) {

            System.out.print("Phone: ");

            String phone = sc.nextLine().trim();

            if (phone.matches("\\d{10}")) {
                return phone;
            }

            System.out.println(
                "❌ Phone number must contain exactly 10 digits."
            );
        }
    }
}