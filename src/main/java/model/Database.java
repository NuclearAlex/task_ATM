package model;

import java.util.HashMap;

public class Database {
    private static HashMap<Integer, Account> data;
    private static int num;
    private static int pass;

    public Database() {
        data = new HashMap<>();
        data.put(1111, new Account("Alex", 12345, new Money("usd", 160)));
        data.put(2222, new Account("Borys", 23451, new Money("usd", 1500)));
        data.put(3333, new Account("Vadim", 34512, new Money("usd", 1700)));
        data.put(4444, new Account("Egor", 45123, new Money("usd", 2300)));
        data.put(5555, new Account("Nikolai", 51234, new Money("usd", 1050)));
    }

    public Database(HashMap<Integer, Account> data) {
        Database.data = data;
    }

    public static int getNum() {
        return num;
    }

    public static int getPass() {
        return pass;
    }

    public HashMap<Integer, Account> getData() {
        return data;
    }

    public void setData(HashMap<Integer, Account> data) {
        Database.data = data;
    }

    public boolean authorization(int number, int password) {
        if (data.get(number) == null) {
            System.out.println("You aren't authorization");
            return false;
        } else {
            num = number;
            pass = password;
            return data.get(number).getPassword() == password;
        }
    }

    public void put(int sum) {
        if (sum < 0 ) {
            System.err.println("Transaction denied");
            return;
        }
        data.get(num).putMoney(sum);
    }

    public void take(int sum) {
        if (sum < 0 || sum > data.get(num).checkBalance()) {
            System.err.println("Transaction denied");
            return;
        }
        data.get(num).takeMoney(sum);
    }

    public int check() {
        if (data.get(num).checkBalance() < 0) {
            data.get(num).setMoney(new Money(0));
        }
        return data.get(num).checkBalance();
    }
}