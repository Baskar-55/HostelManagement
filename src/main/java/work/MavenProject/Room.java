package work.MavenProject;

public class Room {
    private int roomId;
    private String roomType;
    private int capacity;
    private String status;

    public Room(int roomId, String roomType, int capacity, String status) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.capacity = capacity;
        this.status = status;
    }

    public int getRoomId() { return roomId; }
    public String getRoomType() { return roomType; }
    public int getCapacity() { return capacity; }
    public String getStatus() { return status; }
}


