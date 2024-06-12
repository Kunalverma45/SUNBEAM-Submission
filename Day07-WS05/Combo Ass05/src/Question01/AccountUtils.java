package Question01;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

public class AccountUtils implements Operations {
    private List<Account> accounts = new ArrayList<>();

    @Override
    public void addAccount(Account account) throws Exception {
        if (!Validations.isValidAccount(account)) {
            throw new Exception("Invalid account details.");
        }
        accounts.add(account);
        persistData();
    }

    @Override
    public Account displayAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<Account> displayAllAccounts() {
        return accounts;
    }

    @Override
    public void removeAccount(String accountNumber) throws AccountNotFoundException {
        Account account = displayAccount(accountNumber);
        accounts.remove(account);
        persistData();
    }

    @Override
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account account = displayAccount(accountNumber);
        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        account.setBalance(account.getBalance() - amount);
        persistData();
    }

    @Override
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = displayAccount(accountNumber);
        account.setBalance(account.getBalance() + amount);
        persistData();
    }

    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        withdraw(fromAccountNumber, amount);
        deposit(toAccountNumber, amount);
        persistData();
    }

    @Override
    public List<Account> searchAccountByName(String name) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getName().equalsIgnoreCase(name)) {
                result.add(account);
            }
        }
        return result;
    }

    @Override
    public List<Account> searchAccountByEmail(String email) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getEmail().equalsIgnoreCase(email)) {
                result.add(account);
            }
        }
        return result;
    }

    @Override
    public List<Account> searchAccountByPhone(String phone) {
        List<Account> result = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getPhone().equals(phone)) {
                result.add(account);
            }
        }
        return result;
    }

    private void persistData() {
        // Code to persist data in file (not implemented here)
    }
}
