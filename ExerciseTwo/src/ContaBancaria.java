public class ContaBancaria {


    private String userName;
    private int accountNumber;
    private double initialDeposit;
    private double balance = 0.0;
    private double overdraft;

    public ContaBancaria(String userName, int accountNumber, double initialDeposit) {
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.initialDeposit = initialDeposit;
        this.balance = initialDeposit;

        if(initialDeposit <= 500.0){
            this.overdraft = 50.0;
        } else {
            this.overdraft = initialDeposit * 0.5;
        }

        System.out.println("Olá " + userName + ", sua conta de número " + accountNumber +
                " tem um saldo atual de R$" + balance + ", sendo R$" + overdraft +
                " o valor atribuído e disponível de cheque especial.");
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getInitialDeposit(){
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public double getOverdraft(){
        return overdraft;
    }
}
