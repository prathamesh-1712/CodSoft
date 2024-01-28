import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
            return true;
        }
    }
}
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    private void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }
    private void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Updated balance: $" + userAccount.getBalance());
    }
    private void withdraw(double amount) {
        userAccount.withdraw(amount);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial account balance: $");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        int choice;

        do {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            if (choice != 4) {
                atm.performTransaction(choice, scanner);
            }

        } while (choice != 4);

        scanner.close();
    }
}
