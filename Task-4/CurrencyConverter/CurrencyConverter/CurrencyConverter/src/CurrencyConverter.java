import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base currency (e.g., USD):");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Enter the target currency (e.g., EUR):");
        String targetCurrency = scanner.nextLine().toUpperCase();

        double exchangeRate = CurrencyApi.getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate == 0.0) {
            System.out.println("Failed to fetch exchange rate. Please check your inputs or try again later.");
        } else {
            System.out.println("Enter the amount to convert from " + baseCurrency + " to " + targetCurrency + ":");
            double amountToConvert = scanner.nextDouble();

            double convertedAmount = amountToConvert * exchangeRate;
            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
        }

        scanner.close();
    }
}
