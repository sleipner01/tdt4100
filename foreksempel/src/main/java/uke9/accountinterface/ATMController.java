package uke9.accountinterface;

public class ATMController {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Account account = new Account();
        atm.deposit(account, 500);
        atm.deposit(account, 500);
        atm.withdraw(account, 300);
        atm.withdraw(account, 300);
        atm.withdraw(account, 300);
        atm.withdraw(account, 300);
        atm.getBalance(account);
    }
}
