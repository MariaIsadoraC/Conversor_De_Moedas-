import java.util.Map;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaxaCambio taxaCambioService = new TaxaCambio();
        ConversorMoeda conversorMoeda = new ConversorMoeda();

        Map<String, Double> rates = taxaCambioService.obterTaxasDeCambio();
        System.out.println("Bem vindo ao conversor de moedas");

        int opcao = 0;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileiro");
            System.out.println("4) Real Brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Iene Japonês");
            System.out.println("6) Iene Japonês =>> Dólar");
            System.out.println("7) Sair");
            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opção inválida");
                scanner.nextLine();
                continue;
            }
            switch (opcao) {
                case 1:
                    conversorMoeda.converter(scanner, rates, "USD", "ARS");
                    break;
                case 2:
                    conversorMoeda.converter(scanner, rates, "ARS", "USD");
                    break;
                case 3:
                    conversorMoeda.converter(scanner, rates, "USD", "BRL");
                    break;
                case 4:
                    conversorMoeda.converter(scanner, rates, "BRL", "USD");
                    break;
                case 5:
                    conversorMoeda.converter(scanner, rates, "USD", "JPY");
                    break;
                case 6:
                    conversorMoeda.converter(scanner, rates, "JPY", "USD");
                    break;
                case 7:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 7);
    }
}
