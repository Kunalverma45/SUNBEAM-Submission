package Question01;

import java.util.List;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountUtils accountUtils = new AccountUtils();

        while (true) {
            System.out.println("1. Add Account");
            System.out.println("2. Display an Account");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Remove an Account");
            System.out.println("5. Withdraw");
            System.out.println("6. Deposit");
            System.out.println("7. Transfer");
            System.out.println("8. Search Account by Name");
            System.out.println("9. Search Account by Email");
            System.out.println("10. Search Account by Phone");
            System.out.println("11. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter account number:");
                    String accountNumber = scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter phone:");
                    String phone = scanner.nextLine();
                    System.out.println("Enter balance:");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    Account account = new Account(accountNumber, name, email, phone, balance);
                    try {
                        accountUtils.addAccount(account);
                        System.out.println("Account added successfully.");
                    } catch (AccountException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextLine();
                    try {
                        Account acc = accountUtils.displayAccount(accountNumber);
                        System.out.println(acc);
                    } catch (AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    List<Account> accounts = accountUtils.displayAllAccounts();
                    for (Account acc : accounts) {
                        System.out.println(acc);
                    }
                    break;

                case 4:
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextLine();
                    try {
                        accountUtils.removeAccount(accountNumber);
                        System.out.println("Account removed successfully.");
                    } catch (AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextLine();
                    System.out.println("Enter amount to withdraw:");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    try {                        
                    	accountUtils.withdraw(accountNumber, amount);
                    System.out.println("Amount withdrawn successfully.");
                } catch (AccountNotFoundException | InsufficientBalanceException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 6:
                System.out.println("Enter account number:");
                accountNumber = scanner.nextLine();
                System.out.println("Enter amount to deposit:");
                amount = scanner.nextDouble();
                scanner.nextLine();  // Consume newline
                try {
                    accountUtils.deposit(accountNumber, amount);
                    System.out.println("Amount deposited successfully.");
                } catch (AccountNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 7:
                System.out.println("Enter source account number:");
                String fromAccountNumber = scanner.nextLine();
                System.out.println("Enter destination account number:");
                String toAccountNumber = scanner.nextLine();
                System.out.println("Enter amount to transfer:");
                amount = scanner.nextDouble();
                scanner.nextLine();  // Consume newline
                try {
                    accountUtils.transfer(fromAccountNumber, toAccountNumber, amount);
                    System.out.println("Amount transferred successfully.");
                } catch (AccountNotFoundException | InsufficientBalanceException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 8:
                System.out.println("Enter name:");
                name = scanner.nextLine();
                List<Account> accountsByName = accountUtils.searchAccountByName(name);
                for (Account acc : accountsByName) {
                    System.out.println(acc);
                }
                break;

            case 9:
                System.out.println("Enter email:");
                email = scanner.nextLine();
                List<Account> accountsByEmail = accountUtils.searchAccountByEmail(email);
                for (Account acc : accountsByEmail) {
                    System.out.println(acc);
                }
                break;

            case 10:
                System.out.println("Enter phone:");
                phone = scanner.nextLine();
                List<Account> accountsByPhone = accountUtils.searchAccountByPhone(phone);
                for (Account acc : accountsByPhone) {
                    System.out.println(acc);
                }
                break;

            case 11:
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
}

                       
