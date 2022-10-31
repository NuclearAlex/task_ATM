package model;

public class Account {
    private String name;
    private int password;
    private Money money;

    public Account(String name, int password, Money money) {
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public int checkBalance() {
        return money.getQuantity();
    }

    public void putMoney(int sum) {
        if (sum < 0) {
            System.err.println("Transaction denied");
        }
        money.setQuantity(money.getQuantity() + sum);
    }

    public void takeMoney(int sum) {
        if (sum < 0 || sum > money.getQuantity()) {
            System.err.println("Transaction denied");
        }
        money.setQuantity(money.getQuantity() - sum);
    }
}