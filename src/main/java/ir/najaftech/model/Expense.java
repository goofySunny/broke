package ir.najaftech.model;

public class Expense {

    private long id;
    private long amount;
    private String description;
    private ExpenseCategory category;
    private String customCategory;

    public Expense(long amount, String description, ExpenseCategory category, String customCategory) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.customCategory = customCategory;
    }

    public Expense(long id, long amount, String description, ExpenseCategory category, String customCategory) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.customCategory = customCategory;
    }

    public String getCustomCategory() {
        return customCategory;
    }

    public void setCustomCategory(String customCategory) {
        this.customCategory = customCategory;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ExpenseCategory getCategory() {
        return category;
    }
    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "amount=" + amount +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", customCategory='" + customCategory + '\'';
    }
}
