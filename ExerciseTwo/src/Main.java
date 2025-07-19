import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

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
            }
        }
        while (option != 0);
    }

    private static void setAccount(){
        System.out.println("Diga o seu nome: ");
        String name = scanner.next();
        System.out.println("Informe o número da sua conta: ");
        int number = scanner.nextInt();
        System.out.println("Qual o valor de depósito inicial?");
        double deposit = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(name, number, deposit);
    }

    private static void withdraw (){

    }


}
