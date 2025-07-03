package ir.najaftech.model;

public enum Gender {

        MALE,
        FEMALE;

        @Override 
        public String toString() {
        	StringBuilder sb = new StringBuilder();
        	
        	sb.append(this.name().substring(0,1).toUpperCase());
        	sb.append(this.name().substring(1).toLowerCase());
        	return sb.toString();
        }
        
}
