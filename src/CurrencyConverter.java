import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    
    public  static  void main(String[] args) throws IOException {

        boolean running=true;//to continue the program until user exit

        do {
            HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();//used to map the option to currencies

            //add currency codes
            currencyCodes.put(1, "USD");
            currencyCodes.put(2, "CAD");
            currencyCodes.put(3, "EUR");
            currencyCodes.put(4, "HKD");
            currencyCodes.put(5, "INR");

            Integer from, to,yesNo;//for setting validations
            String fromCode, toCode;
            double amount;

            Scanner scan = new Scanner(System.in);

            System.out.println("Welcome to Currency Converter!");

            System.out.println("Currency Converting FROM?");
            System.out.println("1:USD(US dollar) \t 2:CAD(Canadian dollar) \t 3:EUR(Euro) \t 4:HKD(Hong Kong dollar) \t 5:INR(Indian Rupees)");

            from = scan.nextInt();
            while (from < 1 || from > 5) {
                System.out.println("please select valid option(1 to 5)");
                System.out.println("1:USD(US dollar) \t 2:CAD(Canadian dollar) \t 3:EUR(Euro) \t 4:HKD(Hong Kong dollar) \t 5:INR(Indian Rupees)");
                from = scan.nextInt();
            }
            fromCode = currencyCodes.get(from);//input FROM

            System.out.println("Currency Converting TO?");
            System.out.println("1:USD(US dollar) \t 2:CAD(Canadian dollar) \t 3:EUR(Euro) \t 4:HKD(Hong Kong dollar) \t 5:INR(Indian Rupees)");

            to = scan.nextInt();
            while (from.equals(to)) {
                System.out.println("Cannot Convert Same Currency! Choose Another Currency");
                System.out.println("1:USD(US dollar) \t 2:CAD(Canadian dollar) \t 3:EUR(Euro) \t 4:HKD(Hong Kong dollar) \t 5:INR(Indian Rupees)");
                to = scan.nextInt();
            }
            while (to < 1 || to > 5) {
                System.out.println("please select valid option(1 to 5)");
                System.out.println("1:USD(US dollar) \t 2:CAD(Canadian dollar) \t 3:EUR(Euro) \t 4:HKD(Hong Kong dollar) \t 5:INR(Indian Rupees)");
                to = scan.nextInt();
            }
            toCode = currencyCodes.get(to);// input from TO

            System.out.println("Amount you wish to Convert?");
            amount = scan.nextFloat();

            sendHttpGETRequest(fromCode, toCode, amount);//calling the function

            System.out.println("would you like to make another conversion");
            System.out.println("1:Yes / 2:No");

            yesNo=scan.nextInt();
            while(yesNo<1 || yesNo>2){
                System.out.println("please enter valid key:1 or 2");
                yesNo=scan.nextInt();
            }
            if(yesNo!=1){
                running=false;
            }

        }while (running);

        System.out.println("Thank You For Using the Currency Converter");
    }

    private static  void sendHttpGETRequest(String fromCode,String toCode,double amount) throws IOException {

        DecimalFormat f=new DecimalFormat("00.00");//to get only 2 digit after point .
        //Setting up the api
        String GET_URL="https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/"+fromCode.toLowerCase()+".json";
        URL url=new URL(GET_URL);
        HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode= httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in =new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response= new StringBuilder();

            while((inputLine=in.readLine())!=null){
                response.append(inputLine);
            }in.close();

            JSONObject obj=new JSONObject(response.toString());
            Double exchangeRate=obj.getJSONObject(fromCode.toLowerCase()).getDouble(toCode.toLowerCase());
            double convertedAmount=amount*exchangeRate;
            System.out.println("The value of 1 "+fromCode+" :"+f.format(exchangeRate)+" "+toCode);//keep for debugging
            System.out.println();
            System.out.println(f.format(amount)+" " + fromCode +" = " + f.format(convertedAmount)+" " + toCode);
        }
        else{
            System.out.println("request failed");
        }
    }
}
