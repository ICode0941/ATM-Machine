public class User extends Main{

    private String accountNumber;
    private String PIN;
    private double balance = 0;
    private int failedAttempts;
    private boolean isLocked;

    public User(String accountNumber, String PIN, double balance) {
        this.accountNumber = accountNumber;
        this.PIN = PIN;
        this.balance = balance;
        this.failedAttempts = 0;
        this.isLocked = false;
    }

    //Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPIN() {
        return PIN;
    }

    public double getBalance() {
        return balance;
    }

    public boolean getLockedAccounts() {
        return isLocked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    // Method to set new balance (for withdrawal and deposit)
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to increment failed attempts
    public void incrementFailedAttempts() {
        failedAttempts++;
    }

    // Method to lock the account (locked)
    public void lockAccount() {
        isLocked = true;
    }

    //Method for status of account whether locked or not (notLocked)
    public boolean isLocked() {
        return isLocked;
    }

    // Method to reset failed attempts
    public void resetFailedAttempts() {
        failedAttempts = 0;
    }


}
