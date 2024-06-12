package Question01;

import java.io.Serializable;

public class Account implements Serializable {
    private String accountNumber;
    private String name;
    private String email;
    private String phone;
    private double balance;

    // Constructor
    public Account(String accountNumber, String name, String email, String phone, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }
}
