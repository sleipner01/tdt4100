package oving7;

public class CreditAccount extends AbstractAccount {

    private double creditLine;


    
    public CreditAccount(double creditLine) {
        this.setCreditLine(creditLine);
    }



    public double getCreditLine() {
        return this.creditLine;
    }



    public void setCreditLine(double creditLine) {
        if(creditLine < 0) throw new IllegalArgumentException("Nei!");
        if(0-creditLine > super.balance) throw new IllegalStateException("Nei!");
        this.creditLine = creditLine;
    }



    @Override
    protected void internalWithdraw(double amount) {
        if(super.balance - amount < 0-creditLine)
            throw new IllegalStateException("Nei!");

        super.balance -= amount;
    }
    
}
