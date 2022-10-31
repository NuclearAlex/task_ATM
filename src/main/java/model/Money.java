package model;

public class Money {
    private String type;
    private int quantity;

    public Money() {
    }

    public Money(int quantity) {
        this.quantity = quantity;
    }

    public Money(String type) {
        this.type = type;
    }

    public Money(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Money: " + quantity + " " + type ;
    }
}
