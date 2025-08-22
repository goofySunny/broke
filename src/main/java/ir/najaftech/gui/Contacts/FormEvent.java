package ir.najaftech.gui.Contacts;

import java.util.EventObject;

import ir.najaftech.model.EmploymentStatus;
import ir.najaftech.model.Gender;

public class FormEvent extends EventObject {

    private int id;
    private String name;
    private EmploymentStatus employmentStatus;
    private Gender gender;
    private String nationalNumber;

    public FormEvent(Object source, int id) {
        super(source);
        this.id = id;
    }

    public FormEvent(Object source, String name, EmploymentStatus employmentStatus, Gender gender) {
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

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
