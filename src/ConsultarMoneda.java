import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    public String buscarMoneda(String baseMoneda, String monedaDestino, Double valor) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/APIKEY/latest/" + baseMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Principal datos = new Gson().fromJson(response.body(), Principal.class);  // Convertir la respuesta en un objeto Principal

            // Verificar si el código de la moneda de destino existe en el mapa
            if (datos.conversion_rates.containsKey(monedaDestino)) {
                // Obtenemos la tasa de conversión para la monedaDestino
                Double tasaConversion = datos.conversion_rates.get(monedaDestino);

                // Multiplicamos la tasa de conversión por el valor proporcionado
                Double resultado = tasaConversion * valor;

                return "El valor de: " + valor + " " + baseMoneda + "\n" + "Es igual a :" + resultado + " " + monedaDestino;
            } else {
                return "Moneda " + monedaDestino + " no encontrada.";
            }

        } catch (Exception e) {
            return "Error al obtener la tasa de conversión: " + e.getMessage();
        }
    }
}

