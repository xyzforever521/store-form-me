package entity;

public class User {
    private Integer userNo;
    private String userName;
    private String password;
    private Integer userStatus;

    @Override
    public String toString() {
        return "User{" +
                "userNo=" + userNo +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }

    public Integer getUserNo() {
        return userNo;
    }

    public void setUserNo(Integer userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
}
