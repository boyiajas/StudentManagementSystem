package finalprojrct;

public class StudentTable {

    public StudentTable(String FirstName, String LastName, String DOB, String Gender, String ID_NO, String Signed, int StudentID, int StudentCell, int ParentCell) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DOB = DOB;
        this.Gender = Gender;
        this.ID_NO = ID_NO;
        this.Signed = Signed;
        this.StudentID = StudentID;
        this.StudentCell = StudentCell;
        this.ParentCell = ParentCell;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getID_NO() {
        return ID_NO;
    }

    public void setID_NO(String ID_NO) {
        this.ID_NO = ID_NO;
    }

    public String getSigned() {
        return Signed;
    }

    public void setSigned(String Signed) {
        this.Signed = Signed;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public int getStudentCell() {
        return StudentCell;
    }

    public void setStudentCell(int StudentCell) {
        this.StudentCell = StudentCell;
    }

    public int getParentCell() {
        return ParentCell;
    }

    public void setParentCell(int ParentCell) {
        this.ParentCell = ParentCell;
    }
    private String FirstName, LastName, DOB, Gender, ID_NO, Signed;
    private int StudentID, StudentCell, ParentCell;
}
