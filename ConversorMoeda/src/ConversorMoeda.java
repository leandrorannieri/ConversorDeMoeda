import java.util.Scanner;

public class ConversorMoeda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CONVERSOR DE MOEDA ===");

        // Menu de opções com Peso Argentino incluído
        System.out.println("1 - Dólar (USD) para Real (BRL)");
        System.out.println("2 - Euro (EUR) para Real (BRL)");
        System.out.println("3 - Real (BRL) para Dólar (USD)");
        System.out.println("4 - Real (BRL) para Euro (EUR)");
        System.out.println("5 - Peso (ARS) para Real (BRL)");
        System.out.println("6 - Real (BRL) para Peso (ARS)");

        System.out.print("Escolha uma opção (1 a 6): ");
        int opcao = scanner.nextInt();

        System.out.print("Digite o valor a ser convertido: ");
        double valor = scanner.nextDouble();

        double resultado = 0;
        String simboloOrigem = "";
        String simboloDestino = "";

        // Taxas simuladas de câmbio
        final double USD_PARA_BRL = 5.10;
        final double EUR_PARA_BRL = 5.50;
        final double ARS_PARA_BRL = 0.025;

        final double BRL_PARA_USD = 1 / USD_PARA_BRL;
        final double BRL_PARA_EUR = 1 / EUR_PARA_BRL;
        final double BRL_PARA_ARS = 1 / ARS_PARA_BRL;

        switch (opcao) {
            case 1:
                resultado = valor * USD_PARA_BRL;
                simboloOrigem = "USD";
                simboloDestino = "BRL";
                break;
            case 2:
                resultado = valor * EUR_PARA_BRL;
                simboloOrigem = "EUR";
                simboloDestino = "BRL";
                break;
            case 3:
                resultado = valor * BRL_PARA_USD;
                simboloOrigem = "BRL";
                simboloDestino = "USD";
                break;
            case 4:
                resultado = valor * BRL_PARA_EUR;
                simboloOrigem = "BRL";
                simboloDestino = "EUR";
                break;
            case 5:
                resultado = valor * ARS_PARA_BRL;
                simboloOrigem = "ARS";
                simboloDestino = "BRL";
                break;
            case 6:
                resultado = valor * BRL_PARA_ARS;
                simboloOrigem = "BRL";
                simboloDestino = "ARS";
                break;
            default:
                System.out.println("Opção inválida.");
                scanner.close();
                return;
        }

        // Mostra resultado formatado com 2 casas decimais
        System.out.printf("Valor convertido de %s para %s: %.2f %s\n",
                simboloOrigem, simboloDestino, resultado, simboloDestino);

        scanner.close();
    }
}
