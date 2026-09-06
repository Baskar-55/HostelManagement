package work.MavenProject;

import java.util.Scanner;

public class AdminMain {

    public static void main(String[] args) {

        AdminDAO dao = new AdminDAO();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ADMIN LOGIN ===");

        System.out.print("Username: ");
        String username = sc.next();

        System.out.print("Password: ");
        String password = sc.next();

        boolean result = dao.login(username, password);

        if (result) {

            System.out.println("Login Successful!");
            System.out.println("Welcome Admin");

        } else {

            System.out.println("Invalid Username or Password!");

        }
    }
}