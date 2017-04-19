/*
 * Le An Hoang Danh 
 * PS 04304
 * PT 11302
 */
package Bean;

/**
 *
 * @author L.A.H.D
 */
public class Record {
    private String ID;
    private int Type;
    private String Reason;
    private String Date;
    private String StaffId;
    
    public Record(){}

    public Record(String ID, int Type, String Reason, String Date, String StaffId) {
        this.ID = ID;
        this.Type = Type;
        this.Reason = Reason;
        this.Date = Date;
        this.StaffId = StaffId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String StaffId) {
        this.StaffId = StaffId;
    }
    
    
}
