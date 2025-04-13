
import java.util.EventObject;


public class FormEvent extends EventObject {

    private String name;
    private String employmentStatus;
    private String gender;
    private String nationalNumber;

    public FormEvent(Object source, String name, String employmentStatus, String gender) {
        super(source);
        this.name = name;
        this.employmentStatus = employmentStatus;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

}
