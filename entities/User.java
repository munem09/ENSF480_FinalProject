public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private boolean isRegisteredUser;  // Flag to determine if the user is a registered user

    // Constructor
    public User(int userId, String name, String email, String password, boolean isRegisteredUser) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isRegisteredUser = isRegisteredUser;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegisteredUser() {
        return isRegisteredUser;
    }

    public void setRegisteredUser(boolean registeredUser) {
        isRegisteredUser = registeredUser;
    }

    // Method to display user information
    public String displayUserInfo() {
        return "User Name: " + name + " | Email: " + email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isRegisteredUser=" + isRegisteredUser +
                '}';
    }
}
