import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        double extrato = 0;
        boolean isRunning = true;

        while(isRunning){
            System.out.println("------------------------");
            System.out.println("    Banco Pessoal    ");
            System.out.println("------------------------");

            System.out.println("1 - Extrato Bancario");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.println("------------------------");

            System.out.print("Insira uma opção: ");
            int opc = sc.nextInt();

            switch (opc) {
                case 1:
                    mostrarExtrato(extrato);
                    break;
                case 2:
                    extrato += deposito();
                    break;
                case 3:
                    extrato -= saque(extrato);
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Escolha Invalida");
            }
        }
        System.out.println("-----------------------------------");
        System.out.println("   Obrigado por usar nosso banco!");
        System.out.println("-----------------------------------");

        sc.close();
    }


    static void mostrarExtrato(double extrato){
        System.out.printf("R$%.2f%ns", extrato);
    }

    static double deposito(){
        double valor;

        System.out.print("Insira o valor a ser Depositado: ");
        valor = sc.nextDouble();

        if(valor < 0 ) {
            System.out.println("Valor não pode ser negativo.");
            return 0;
        }

        return valor;
    }

    static double saque(double extrato){
        double valor;
        System.out.println("Entre com o valor para sacar: ");
        valor = sc.nextDouble();

        if(valor > extrato){
            System.out.println("Fundo insuficiente para saque.");
            return 0;
        } else if (valor < 0) {
            System.out.println("Valor não pode ser negativo. ");
            return 0;
        }
        return valor;
    }
}