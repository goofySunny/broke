package ir.najaftech.model;

public class Person {
    
    private long id;
    private String name;
    private EmploymentStatus employmentStatus;
    private Gender gender;
    private boolean local;
    private String nationalnumber;

    public Person(long id, String name, EmploymentStatus employmentStatus, Gender gender, boolean local,
            String nationalnumber) {
        this.id = id;
        this.name = name;
        this.employmentStatus = employmentStatus;
        this.gender = gender;
        this.local = local;
        this.nationalnumber = nationalnumber;
    }

    public Person(String name, EmploymentStatus employmentStatus, Gender gender, boolean local, String nationalnumber) {
        this.name = name;
        this.employmentStatus = employmentStatus;
        this.gender = gender;
        this.local = local;
        this.nationalnumber = nationalnumber;
    }
    
    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public String getNationalnumber() {
        return nationalnumber;
    }

    public void setNationalnumber(String nationalnumber) {
        this.nationalnumber = nationalnumber;
    }

}
