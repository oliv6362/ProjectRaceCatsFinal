package Entity;

public class User {

    private int userID;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private int phoneNumber;
    private boolean login;

    public User() {

    }

    //Til at finde en user i database
    public User(int userID, String fName, String lName, String email, String password, int phoneNumber) {
        this.userID = userID;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    //Til oprettelse af en bruger
    public User(String fName, String lName, String email, String password, int phoneNumber) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User(String email, String password) { //Til login/session request
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getLogin() {
        return login;
    }

    public void setLogin(boolean login) {this.login = login;}

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userID +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}