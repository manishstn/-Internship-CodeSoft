import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyApi {
    private static final String API_KEY = "2a9de0847b7b5162cc2c44a06fdb77cd"; // Replace with provided API key
    private static final String API_URL = "https://v6.exchangeratesapi.io/latest";

    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        double exchangeRate = 0.0;
        try {
            URL url = new URL(API_URL + "?access_key=" + API_KEY + "&base=" + baseCurrency + "&symbols=" + targetCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream inputStream = connection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            StringBuilder response = new StringBuilder();
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            // Parse JSON response to get exchange rate
            // For simplicity, assuming response format: {"rates":{"USD":1.23}}
            String json = response.toString();
            String rateStr = json.substring(json.indexOf(targetCurrency) + 5, json.indexOf("}"));
            exchangeRate = Double.parseDouble(rateStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exchangeRate;
    }
}
