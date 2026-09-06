package work.MavenProject;

import java.util.Scanner;

public class RoomMain {
    public static void main(String[] args) {

        RoomDAO dao = new RoomDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== ROOM MENU ===");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Update Room Status");
            System.out.println("4. Delete Room");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Room ID: ");
                    int id = sc.nextInt();

                    System.out.print("Room Type: ");
                    String type = sc.next();

                    System.out.print("Capacity: ");
                    int cap = sc.nextInt();

                    System.out.print("Status: ");
                    String status = sc.next();

                    Room room = new Room(id, type, cap, status);
                    dao.addRoom(room);
                    break;

                case 2:
                    dao.viewRooms();
                    break;

                case 3:
                    System.out.print("Room ID: ");
                    int rid = sc.nextInt();

                    System.out.print("New Status: ");
                    String st = sc.next();

                    dao.updateRoomStatus(rid, st);
                    break;

                case 4:
                    System.out.print("Room ID: ");
                    int did = sc.nextInt();

                    dao.deleteRoom(did);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}