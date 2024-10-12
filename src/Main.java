import java.util.Scanner;

/*
 * @author: Divine Grace G. Garduque
 * @date: October 12, 2024
 * @project: ATM Withdrawal System
 */

public class Main {

    public static void main(String[] args) {

        // Objects
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        while (true) {
            System.out.println(" ");
            System.out.println(" *** ATM Withdrawal System *** ");
            System.out.println(" ");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            //Try catch to handle string inputs
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1: // Create Account
                        System.out.print("Enter account number: ");
                        String newAccountNumber = scanner.nextLine();
                        System.out.print("Enter PIN: ");
                        String newPin = scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        double initialBalance = scanner.nextDouble();
                        atm.createAccount(newAccountNumber, newPin, initialBalance);
                        break;

                    case 2: // Login
                        System.out.print("Enter account number: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("Enter PIN: ");
                        String pin = scanner.nextLine();

                        User user = atm.authenticator(accountNumber, pin);
                        if (user != null) {
                            while (true) {
                                System.out.println("1. Check Balance");
                                System.out.println("2. Deposit Money");
                                System.out.println("3. Withdraw Money");
                                System.out.println("4. Logout");
                                int choice2 = scanner.nextInt();

                                switch (choice2) {
                                    case 1: // Check Balance
                                        atm.checkBalance(user, user.getBalance());
                                        break;
                                    case 2: // Deposit Money
                                        atm.deposit(user, user.getBalance());
                                        break;
                                    case 3: // Withdraw Money
                                        System.out.print("Enter amount to withdraw: ");
                                        double amount = scanner.nextDouble();
                                        atm.withdraw(user, amount, user.getBalance());
                                        break;
                                    case 4: // Logout
                                        atm.logout();
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Please try again.");
                                }
                                if (choice2 == 4) break; // Break the loop to logout
                            }
                        }
                        break;

                    case 3: // Exit
                        System.out.println("Thank you for using this ATM!");
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                scanner.nextLine();
            }
        }
    }
}
