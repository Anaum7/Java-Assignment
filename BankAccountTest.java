import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposited: $" + amount);
            System.out.println("Current Balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrew: $" + amount);
                System.out.println("Withdrew: $" + amount);
                System.out.println("Current Balance: $" + balance);
            } else {
                System.out.println("Error: Insufficient funds for withdrawal of $" + amount);
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to check balance
    public double checkBalance() {
        System.out.println("Current Balance: $" + balance);
        return balance;
    }

    // Method to print transaction history
    public void printTransactionHistory() {
        System.out.println("Transaction History for Account: " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class BankAccountTest {
    public static void main(String[] args) {
        // Create multiple account instances
        BankAccount account1 = new BankAccount("123456", "Alice");
        BankAccount account2 = new BankAccount("654321", "Bob");

        // Test account 1
        account1.deposit(500);
        account1.withdraw(200);
        account1.withdraw(400); // Should show insufficient funds
        account1.checkBalance();
        account1.printTransactionHistory();

        System.out.println();

        // Test account 2
        account2.deposit(1000);
        account2.withdraw(300);
        account2.withdraw(800); // Should show insufficient funds
        account2.checkBalance();
        account2.printTransactionHistory();
    }
}