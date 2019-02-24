package bt.edu.cst.easycst;

/**
 * Created by Tek Nath Acharya nathtek136@gmail.com
 * for Easy CST app
 */
public class ModuleDetails {
    private String mcode,mname,mtutor;
    int moduleID,attendance;

    public int getModuleID() {
        return moduleID;
    }
    public void setModuleId(int moduleID) {
        this.moduleID = moduleID;
    }

    public String getMcode() { return mcode; }
    public void setMcode(String mcode) {
        this.mcode = mcode;
    }

    public String getMname() { return mname; }
    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtutor() {
        return mtutor;
    }
    public void setMtutor(String mtutor) { this.mtutor = mtutor; }

    public int getMattendance() {
        return attendance;
    }
    public void setMattendance(int attendance) {
        this.attendance = attendance;
    }
}
