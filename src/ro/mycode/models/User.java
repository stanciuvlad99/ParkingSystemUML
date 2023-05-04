package ro.mycode.models;

public class User {

    private int userId;
    private String userName;
    private String userEmail;
    private String userAdress;
    private double userDate;

    public User(int userId, String userName, String userEmail, String userAdress, double userDate) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAdress = userAdress;
        this.userDate = userDate;
    }

    public User(String text){
        String []split=text.split(",");
        this.userId=Integer.parseInt(split[0]);
        this.userName=split[1];
        this.userEmail=split[2];
        this.userAdress=split[3];
        this.userDate=Double.parseDouble(split[4]);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public double getUserDate() {
        return userDate;
    }

    public void setUserDate(double userDate) {
        this.userDate = userDate;
    }

    public String descriere() {
        String text = "";
        text += "user id " + userId + "\n";
        text += "username " + userName + "\n";
        text += "email " + userEmail + "\n";
        text += "adress " + userAdress + "\n";
        text += "date " + userDate + "\n";
        return text;
    }

    public String toSave() {
        return userId+","+userName+","+ userEmail +","+ userAdress +","+ userDate;
    }

}
