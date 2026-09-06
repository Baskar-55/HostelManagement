package work.MavenProject;


import java.util.Scanner;

public class StudentMain {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=== STUDENT MENU ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Phone");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

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

                    System.out.print("Student ID: ");
                    int uid = sc.nextInt();

                    System.out.print("New Phone: ");
                    String newPhone = sc.next();

                    dao.updateStudentPhone(uid, newPhone);

                    break;

                case 4:

                    System.out.print("Student ID: ");
                    int did = sc.nextInt();

                    dao.deleteStudent(did);

                    break;

                case 5:

                    System.exit(0);

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}