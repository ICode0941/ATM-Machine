import java.util.ArrayList;
import java.util.Scanner;

public class ATM extends Main{

    private ArrayList<User> users;
    private User currentUser;
    private double dailyWithdrawLimit = 500;
    private double withdrawnAmount = 0;

    Scanner scanner = new Scanner(System.in);

    public ATM() {
        users = new ArrayList<>();
    }

    //login
    public User authenticator(String accountNumber, String PIN) {
        for (User user : users) {
            if (user.getAccountNumber().equals(accountNumber)) {
                if (user.isLocked()) {
                    System.out.println("User account locked!");
                    return null;
                }
                else if (user.getPIN().equals(PIN)) {
                    user.resetFailedAttempts();
                    return user;
                }
                else {
                    user.incrementFailedAttempts();
                    if (user.getFailedAttempts() >= 3){
                        user.lockAccount();
                        System.out.println("Account locked due to exceeding limits!");
                    }
                    System.out.println("Invalid Pin!");
                    System.out.println("Attempts Left: " + (3 - user.getFailedAttempts()));
                    return null;
                }
            }
        }
        currentUser.getAccountNumber();
        System.out.println("Account not found!");
        return null;
    }

    //create account
    public void createAccount(String accountNumber, String pin, double balance) {
        for (User user : users) {
            if (user.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account number already exists.");
                return;
            }
        }
        users.add(new User(accountNumber, pin, balance));
        System.out.println("Account created successfully.");
    }

    //logout
    public void logout() {
        System.out.println("Logged out successfully.");
        if (currentUser != null) {
            currentUser.resetFailedAttempts(); // Reset failed attempts
            currentUser = null; // Clear current user reference
        }
    }

    //checking of balance
    public void checkBalance(User user, double balance) {
        System.out.printf("Current Balance: Php %.2f%n", balance);
    }

    //deposit
    public void deposit(User user, double balance) {
        System.out.println("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        user.setBalance(user.getBalance() + depositAmount);
        System.out.printf("New Balance: Php %.2f%n", user.getBalance());
    }

    //withdraw
    public void withdraw(User user, double amount, double balance) {
        if (amount > user.getBalance()) {
            System.out.println("Insufficient funds.");
            return;
        }
        else if (withdrawnAmount + amount > dailyWithdrawLimit) {
            System.out.println("Daily withdrawal limit exceeded.");
            return;
        }
        else if(withdrawnAmount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        user.setBalance(balance - amount);
        withdrawnAmount += amount;
        printReceipt(amount, user.getBalance());
    }

    //print of receipt (withdraw)
    private void printReceipt(double withdrawnAmount, double remainingBalance) {

        System.out.println("Do you want a receipt? ( YES / NO )");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            System.out.println(" --- Receipt --- ");
            System.out.printf("Amount Withdrawn: Php %.2f%n", withdrawnAmount);
            System.out.printf("Remaining Balance: Php %.2f%n", remainingBalance);
            System.out.println(" ");
        }

        else if (choice.equalsIgnoreCase("no")) {
            System.out.println("Thank you for using our ATM machine!");
        }

    }


}
