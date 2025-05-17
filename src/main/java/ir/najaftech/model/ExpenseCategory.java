package ir.najaftech.model;

public enum ExpenseCategory {

    RELATIONSHIP,
    FOOD,
    DEBT,
    OTHER;

    @Override
    public String toString() {
        String sb = name().charAt(0) +
                name().substring(1).toLowerCase();
        return sb;
    }
}
