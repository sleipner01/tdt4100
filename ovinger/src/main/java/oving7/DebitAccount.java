package oving7;

public class DebitAccount extends AbstractAccount {

    @Override
    protected void internalWithdraw(double amount) {
        if(super.balance - amount < 0) throw new IllegalStateException("For lav saldo"); 
        super.balance -= amount;
    }
    
}
