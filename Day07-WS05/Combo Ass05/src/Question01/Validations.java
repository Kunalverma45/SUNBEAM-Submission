package Question01;

public class Validations {
    public static boolean isValidAccount(Account account) {
        return isValidName(account.getName()) &&
               isValidBalance(account.getBalance()) &&
               isValidEmail(account.getEmail()) &&
               isValidPhone(account.getPhone());
    }

    public static boolean isValidName(String name) {
        return name != null && name.length() > 5;
    }

    public static boolean isValidBalance(double balance) {
        return balance > 100;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.length() == 10 && phone.chars().allMatch(Character::isDigit);
    }
}
