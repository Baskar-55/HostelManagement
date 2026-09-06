package work.MavenProject;

public class Complaint {

    private int complaintId;
    private int studentId;
    private String complaint;
    private String complaintDate;
    private String status;

    public Complaint(int complaintId, int studentId,
                     String complaint, String complaintDate,
                     String status) {

        this.complaintId = complaintId;
        this.studentId = studentId;
        this.complaint = complaint;
        this.complaintDate = complaintDate;
        this.status = status;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getComplaintDate() {
        return complaintDate;
    }

    public String getStatus() {
        return status;
    }
}