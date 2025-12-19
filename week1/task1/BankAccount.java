package week1.task1;

public class BankAccount {

    private int accountNumber;
    private String holderName;
    private double balance;
    private String bankName;

    public BankAccount(int accountNumber, String holderName,
                       double balance, String bankName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.bankName = bankName;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    @Override
    public String toString() {
        return "task1.week1.day5.BankAccount [accountNumber=" + accountNumber +
                ", holderName=" + holderName +
                ", balance=" + balance +
                ", bankName=" + bankName + "]";
    }
}
