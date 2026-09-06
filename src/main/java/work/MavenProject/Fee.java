package work.MavenProject;



public class Fee {

    private int feeId;
    private int studentId;
    private double amount;
    private String paymentDate;
    private String status;

    public Fee(int feeId, int studentId, double amount,
               String paymentDate, String status) {

        this.feeId = feeId;
        this.studentId = studentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public int getFeeId() {
        return feeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getStatus() {
        return status;
    }
}
