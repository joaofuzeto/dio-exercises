import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private final static ContaBancaria conta = new ContaBancaria();


    public static void main(String[] args) {
        scanner.useDelimiter("\\n");
        var option = -1;

        do {
            System.out.println("===Seja bem-vindo, escolha uma opção===");
            System.out.println("1 - Abrir uma conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Consultar cheque especial");
            System.out.println("4 - Depositar dinheiro");
            System.out.println("5 - Sacar dinheiro");
            System.out.println("6 - Pagar um boleto");
            System.out.println("7 - Verificar se a conta está usando cheque especial");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            switch (option){
                case 1 -> setAccount();
                case 2 -> balanceUpdated();
                case 3 -> overdraftAmount();
                case 4 -> depositFunction();
                case 5 -> withdraw();
                case 6 -> payBankSlip();
                case 7 -> isUsingOverdraft();
                case 0 -> System.exit(0);
                default -> System.out.println("Ops... opção inválida");
            }
        }
        while (option != 0);
    }

    private static void setAccount(){
        System.out.println("Diga o seu nome: ");
        String name = scanner.next();
        conta.setUserName(name);
        System.out.println("Qual o valor de depósito inicial?");
        double deposit = scanner.nextDouble();
        conta.setInitialDeposit(deposit);

        conta.setBalance(deposit);

        if(deposit <= 500.0){
            conta.setOverdraft(50.0);
            conta.setOverdraftInitial(50.0);
        } else {
            conta.setOverdraft(deposit * 0.5);
            conta.setOverdraftInitial(deposit * 0.5);
        }

        if(name != null || deposit != 0.0) {
            System.out.println("Olá " + conta.getUserName() + ", seu depósito inicial foi de R$" + conta.getInitialDeposit() +
                    ", você tem um saldo atual de R$" + conta.getBalance() + ", além disso foi atribuído R$" + conta.getOverdraft() +
                    " de cheque especial.");
        }
    }

    private static void balanceUpdated(){
        var balancePhrase = conta.getBalance();
        System.out.println("O saldo atual da sua conta é de R$" + balancePhrase + ".");
    }

    private static void overdraftAmount(){
        var overdraftValue = conta.getOverdraft();
        System.out.println("O valor do seu cheque especial é de R$" + overdraftValue);
    }

    private static void depositFunction(){
        System.out.println("Digite o valor que você deseja depositar:");
        double depositAmount = scanner.nextDouble();
        var overdraftUsed = conta.getOverdraftInitial() - conta.getOverdraft();
        var overdraftTax = overdraftUsed * 0.20;

        if(conta.getOverdraft() != conta.getOverdraftInitial() && overdraftTax <= conta.getBalance()) {
            conta.setOverdraft(conta.getOverdraftInitial());
            conta.setBalance((depositAmount - overdraftUsed) - overdraftTax);
            System.out.println("Agora que tem saldo suficiente, cobraremos uma taxa de 20% do valor solicitado"
                    + " e seu novo saldo é de R$" + conta.getBalance());
        }else {
            double newBalance = conta.getBalance() + depositAmount;
            conta.setBalance(newBalance);
        }

        System.out.println("O valor depositado é de R$" + depositAmount + " e o seu saldo agora é de R$"
        + conta.getBalance() + ".");
    }

    private static void withdraw(){
        System.out.println("Digite o valor que você deseja sacar:");
        double withdrawAmount = scanner.nextDouble();

        if(withdrawAmount <= conta.getBalance()){
            double newBalance = conta.getBalance() - withdrawAmount;
            System.out.println("O valor de R$" + withdrawAmount + " pode ser sacado e seu saldo agora é de R$"
            + newBalance + ".");
            conta.setBalance(newBalance);
        } else if(withdrawAmount > conta.getBalance() && withdrawAmount <= conta.getBalance() + conta.getOverdraft()){
            double newOverdraft = conta.getOverdraft() - (withdrawAmount - conta.getBalance());
            System.out.println("O valor é maior que o seu saldo atual, que é de R$" + conta.getBalance() +
                    ", mas utilizaremos o seu cheque especial, que cobre o valor e agora é de R$"
                    + newOverdraft + ".");
            conta.setBalance(0.0);
            conta.setOverdraft(newOverdraft);
        } else if(withdrawAmount > conta.getBalance() + conta.getOverdraft()){
            System.out.println("Não é possível sacar essa quantia. O valor excede o seu saldo atual somado "
                                + "ao valor do seu cheque especial.");
        }
    }

    private static void payBankSlip(){
        System.out.println("Qual o valor do boleto: ");
        double bankSlipValue = scanner.nextDouble();

        if(bankSlipValue <= conta.getBalance()){
            double newBalance = conta.getBalance() - bankSlipValue;
            System.out.println("O boleto foi pago com sucesso.");
            conta.setBalance(newBalance);
        } else if(bankSlipValue > conta.getBalance() && bankSlipValue <= conta.getBalance() + conta.getOverdraft()){
            double newOverdraft = conta.getOverdraft() - (bankSlipValue - conta.getBalance());
            System.out.println("O valor do boleto é maior que o seu saldo atual, que é de R$" + conta.getBalance() +
                    ", mas utilizaremos o seu cheque especial, que cobre o valor e agora é de R$"
                    + newOverdraft + ".");
            conta.setBalance(0.0);
            conta.setOverdraft(newOverdraft);
        } else if(bankSlipValue > conta.getBalance() + conta.getOverdraft()){
            System.out.println("Não é possível pagar esse boleto. O valor excede o seu saldo atual somado "
                    + "ao valor do seu cheque especial.");
        }
    }

    private static void isUsingOverdraft(){
        if(conta.getOverdraft() != conta.getOverdraftInitial()){
            System.out.println("Você está utilizando o cheque especial.");
        } else{
            System.out.println("Você não está utilizando o cheque especial.");
        }
    }

}
