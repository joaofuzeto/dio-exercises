public class ContaBancaria {


    private String userName;
    private double initialDeposit;
    private double balance = 0.0;
    private double overdraftInitial;
    private double overdraft;

    public ContaBancaria(){
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getInitialDeposit(){
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public double getOverdraftInitial(){
        return overdraftInitial;
    }

    public void setOverdraftInitial(double overdraftInitial){
        this.overdraftInitial = overdraftInitial;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
}
