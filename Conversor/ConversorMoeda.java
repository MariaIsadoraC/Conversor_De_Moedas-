import java.util.Map;
import java.util.Scanner;

public class ConversorMoeda {
    public void converter(Scanner scanner, Map<String, Double> rates, String de, String para) {
        System.out.println("Digite o valor em " + de + ":");
        double valor = scanner.nextDouble();
        
        double taxa = rates.get(para) / rates.get(de);
        double convertido = valor * taxa;
        
        System.out.printf("O valor em %s é: %.2f%n", para, convertido);
    }
}
