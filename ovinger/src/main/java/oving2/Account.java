package oving2;

public class Account {
    
    private double balance = 0.0;
    private double interestRate = 0.0;

    public Account(double balance, double interestRate) {        
        deposit(balance);
        setInterestRate(interestRate);
    }

    private boolean isNegativeDouble(double value) {
        if(value < 0) return true;
        return false;
    }

    public void deposit(double amount) {
        if(isNegativeDouble(amount))
            throw new IllegalArgumentException("The value can't be negative.");

        this.balance += amount;
        System.out.println("Added " + amount + " to the account.");
    }

    public void withdraw(double amount) {
        if(isNegativeDouble(amount))
            throw new IllegalArgumentException("The value can't be negative.");
            
        if(this.balance - amount < 0)
            throw new IllegalArgumentException("You are withdrawing too much!");
            

        this.balance -= amount;
    }

    public void addInterest() {
        this.balance += this.balance * this.interestRate;
        System.out.println("New balance is: " + this.balance);
    }

    public double getBalance() {
        return this.balance;
    }

    public double getInterestRate() {
        return this.interestRate*100;
    }

    public void setInterestRate(double rate) {
        if(isNegativeDouble(rate))
            throw new IllegalArgumentException("The value can't be negative.");

        this.interestRate = rate/100;
    }

    public static void main(String[] args) {
        Account account2 = new Account(5000, 1.1);
        System.out.println(account2);

        Account account = new Account(5000, -1);
        System.out.println(account);

    }

    @Override
    public String toString() {
        return "Account [balance=" + balance
                + ", interestRate=" + interestRate + "]";
    }

}
