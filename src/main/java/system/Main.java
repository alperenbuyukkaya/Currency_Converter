package system;

import okhttp3.OkHttpClient;
import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        InterfaceManager mainUI = new InterfaceManager();
        RequestHandler requestHandler = new RequestHandler();
        String firstCurrency,secondCurrency;
        JSONObject exchangeRates;
        double currencyAmount;
        while (true){
            firstCurrency = mainUI.getInput(String.class, true, "Enter the currency to be converted from: ");
            secondCurrency = mainUI.getInput(String.class, true, "Enter the currency to be converted to: ");
            currencyAmount = mainUI.getInput(Double.class, true, "Enter the amount to be converted: ");
            String mainURL = "https://api.frankfurter.app/latest?base=" + firstCurrency + "&symbols=" + secondCurrency;
            try{
                exchangeRates = requestHandler.getURL(mainURL);
            }catch (Exception e){
                System.out.println("\nInvalid currencies please try again.\n");
                continue;
            }
            break;
        }

        double mainRate = (double) exchangeRates.get(secondCurrency);
        System.out.println(currencyAmount + " " + firstCurrency + " is equal to " + numberFormat.format(currencyAmount * mainRate) + " " + secondCurrency + ".");
    }
}