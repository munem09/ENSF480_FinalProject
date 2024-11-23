import java.util.Date;

public class Payment {
    private int paymentId;
    private int userId;
    private double amount;
    private String paymentMethod; // e.g., "Credit Card", "Debit Card"
    private Date paymentDate;
    private boolean isSuccessful;

    // Constructor
    public Payment(int paymentId, int userId, double amount, String paymentMethod, Date paymentDate, boolean isSuccessful) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.isSuccessful = isSuccessful;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    // Method to get payment status
    public String getPaymentStatus() {
        return isSuccessful ? "Payment Successful" : "Payment Failed";
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", isSuccessful=" + isSuccessful +
                '}';
    }
}
