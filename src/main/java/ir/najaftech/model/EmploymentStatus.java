package ir.najaftech.model;

public enum EmploymentStatus {

    EMPLOYED,
    SELF_EMPLOYED,
    UNEMPLOYED;
	
    @Override 
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(this.name().substring(0,1).toUpperCase());
    	sb.append(this.name().substring(1).toLowerCase());
    	return sb.toString();
    }

}
