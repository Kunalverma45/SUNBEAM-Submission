package Question01;

import java.util.List;

import javax.management.InvalidAttributeValueException;

public interface Operations {
    void addAccount(Account account) throws InvalidAttributeValueException;
    Account displayAccount(String accountNumber) throws AccountNotFoundException;
    List<Account> displayAllAccounts();
    void removeAccount(String accountNumber) throws AccountNotFoundException;
    void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException;
    void deposit(String accountNumber, double amount) throws AccountNotFoundException;
    void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException;
    List<Account> searchAccountByName(String name);
    List<Account> searchAccountByEmail(String email);
    List<Account> searchAccountByPhone(String phone);
}
