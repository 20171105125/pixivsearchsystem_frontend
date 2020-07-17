package Bean;

import java.util.Date;

public class Users {
    private int userId;
    private String userEmail;
    private String userPwd;
    private Date userRegistDate;

    public Users(int userId, String userEmail, String userPwd){
        super();
        this.userId =userId;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getUserRegistDate() {
        return userRegistDate;
    }

    public void setUserRegistDate(Date userRegistDate) {
        this.userRegistDate = userRegistDate;
    }
}
