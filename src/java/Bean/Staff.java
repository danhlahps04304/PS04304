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
public class Staff {
    private String ID;
    private String Name;
    private boolean Gender;
    private String Date;
    private String Photo;
    private String Email;
    private String Phone;
    private float Salary;
    private String Note;
    private String DepartId;
    
    public Staff(){}

    public Staff(String ID, String Name, boolean Gender, String Date, String Photo, String Email, String Phone, float Salary, String Note, String DepartId) {
        this.ID = ID;
        this.Name = Name;
        this.Gender = Gender;
        this.Date = Date;
        this.Photo = Photo;
        this.Email = Email;
        this.Phone = Phone;
        this.Salary = Salary;
        this.Note = Note;
        this.DepartId = DepartId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getDepartId() {
        return DepartId;
    }

    public void setDepartId(String DepartId) {
        this.DepartId = DepartId;
    }
    
    
    
}
