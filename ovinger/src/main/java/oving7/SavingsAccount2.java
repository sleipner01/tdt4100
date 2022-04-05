package oving7;

public class SavingsAccount2 extends AbstractAccount {

    private int withdrawels;
    private double fee;


    public SavingsAccount2(int withdrawels, double fee) {
        this.withdrawels = withdrawels;
        this.fee = fee;
    }


    @Override
    protected void internalWithdraw(double amount) {        
        if(withdrawels == 0) {
            if(super.balance - this.fee - amount < 0)
                throw new IllegalStateException("Nei!");
            super.balance -= this.fee + amount;
            return;
        }

        if(super.balance - amount < 0)
            throw new IllegalStateException("Nei!");
        
        super.balance -= amount;
        this.withdrawels--;
    }
    
}
