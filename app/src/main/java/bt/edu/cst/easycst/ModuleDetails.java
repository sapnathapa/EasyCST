package bt.edu.cst.easycst;

/**
 * Created by Tek Nath Acharya nathtek136@gmail.com
 * for Easy CST app
 */
public class ModuleDetails {
    private String name,address,mobileNo,professiion;
    int userId;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    public String getProfessiion() {
        return professiion;
    }
    public void setProfessiion(String professiion) {
        this.professiion = professiion;
    }
}
