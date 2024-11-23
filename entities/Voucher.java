import java.util.Date;

public class Voucher {
    private int voucherId;
    private double amount;
    private Date expirationDate;
    private RegisteredUser user;

    // Constructor
    public Voucher(int voucherId, double amount, Date expirationDate, RegisteredUser user) {
        this.voucherId = voucherId;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.user = user;
    }

    // Getters and Setters
    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    // Method to check if the voucher is expired
    public boolean isExpired() {
        Date currentDate = new Date();
        return expirationDate.before(currentDate);
    }

    // Method to display voucher details
    public String displayVoucherInfo() {
        return "Voucher ID: " + voucherId + " | Amount: $" + amount +
               " | Expiration Date: " + expirationDate.toString();
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "voucherId=" + voucherId +
                ", amount=" + amount +
                ", expirationDate=" + expirationDate +
                ", user=" + user.getName() +
                '}';
    }
}
