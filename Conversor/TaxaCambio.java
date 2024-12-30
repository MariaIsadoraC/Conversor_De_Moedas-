import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import com.google.gson.Gson;

public class TaxaCambio {
    private static final String URL_API = "https://v6.exchangerate-api.com/v6/99db72542927eb03626ce9c0/latest/USD";
    private final Gson gson = new Gson();

    public Map<String, Double> obterTaxasDeCambio() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_API))
                    .build();
            
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            ExchangeRateApiResponse apiResponse = gson.fromJson(response.body(), ExchangeRateApiResponse.class);
            
            return apiResponse.conversion_rates;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar taxas de câmbio. Usando valores padrão.");
            return Map.of(
                "ARS", 98.5,
                "BRL", 5.5,
                "JPY", 110.5
            );
        }
    }
}

