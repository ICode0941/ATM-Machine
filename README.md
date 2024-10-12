ATM Withdrawal System Features

1. **Create User**:
   - Allows new users to create an account by providing an account number, PIN, and initial balance. 
   - The system checks for duplicate account numbers to ensure uniqueness.

2. **Login**:
   - Users can log into their accounts by entering their account number and PIN.
   - The system verifies these credentials and grants access if they are valid.
   - If credentials are incorrect after three attempts, the account is locked for security reasons.

3. **Logout**:
   - Ends the current session, clearing user data and resetting any failed attempts.
   - This ensures that the account is secure after the user has finished their transactions.

4. **Authenticate User**:
   - The system checks the entered account number and PIN against stored values.
   - If the credentials are incorrect after three attempts, the account is locked to prevent unauthorized access.

5. **Check Balance**:
   - Once authenticated, users can view their current account balance.
   - This feature helps users stay informed about their funds before making transactions.

6. **Deposit Money**:
   - Users can add funds to their account by specifying an amount to deposit.
   - The system updates the balance accordingly, allowing for easy management of funds.

7. **Withdraw Money**:
   - Users can request to withdraw a specific amount.
   - The system checks if sufficient funds are available in the account.
   - The system also checks if the requested withdrawal exceeds the daily limit of $500.
   - If the conditions are met, the transaction is processed; otherwise, an appropriate error message is displayed.

8. **Print Receipt**:
   - After a successful withdrawal, the system generates a receipt detailing the withdrawn amount and the remaining balance.
   - This provides a record of the transaction for the user’s reference.
