public class RegisteredUser extends User {
    private String address;
    private String creditCardNumber;
    private double accountBalance;
    private boolean isAnnualFeePaid;

    // Constructor
    public RegisteredUser(int userId, String name, String email, String password, String address, String creditCardNumber, double accountBalance, boolean isAnnualFeePaid) {
        // Pass 'true' for isRegistered, since RegisteredUser should always be considered registered
        super(userId, name, email, password, true);  
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.accountBalance = accountBalance;
        this.isAnnualFeePaid = isAnnualFeePaid;
    }

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isAnnualFeePaid() {
        return isAnnualFeePaid;
    }

    public void setAnnualFeePaid(boolean annualFeePaid) {
        isAnnualFeePaid = annualFeePaid;
    }

    // Method to charge annual fee
    public void chargeAnnualFee() {
        if (!isAnnualFeePaid) {
            this.accountBalance -= 20.00; // Deduct annual fee from balance
            isAnnualFeePaid = true;
        }
    }

    // Override toString() method to display RegisteredUser details
    @Override
    public String toString() {
        return "RegisteredUser{" +
                "userId=" + getUserId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", isAnnualFeePaid=" + isAnnualFeePaid +
                '}';
    }
}
