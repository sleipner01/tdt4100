package stateandbehavior;

class Account {

    double balance = 0.0;
    double interestRate = 0.0;

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Added " + amount + " to the account.");
        }
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
        interestRate = rate/100;
    }

    public static void main(String[] args) {
        Account account = new Account();
        System.out.println(account);
        account.setInterestRate(15);
        System.out.println(account);
        account.deposit(50_000);
        System.out.println(account);
        account.addInterest();
        System.out.println(account);

    }

    @Override
    public String toString() {
        return "Account [balance=" + balance
                + ", interestRate=" + interestRate + "]";
    }

}