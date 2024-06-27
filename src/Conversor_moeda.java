import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Conversor_moeda {

    static ArrayList<String> historico = new ArrayList();

    public static void historico_convercoes(String moedas_convert){
        historico.add(moedas_convert);
    }
    public static String getHistorico(){
        return historico.toString();
    }

    public static String consumir_API(String moeda) {
        String url_str = "https://v6.exchangerate-api.com/v6/a0c5f81475c822aecad6d9aa/latest/" + moeda;

        return url_str;
    }

    public static void get_Obj_Json(String jsonn) throws IOException, InterruptedException {

        // Making Request
        URL url = new URL(jsonn);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();


        String conversion_rates1 = jsonobj.get("base_code").getAsString();




// Pegando Objeto Json
        JsonObject conversion_rates = (JsonObject) jsonobj.get("conversion_rates");



// Acessando objeto
        String moeda = "";
        moeda = get_moeda_conversao();
        String req_result = conversion_rates.get(moeda).getAsString();

        Double moeda_convert= Double.valueOf(req_result);

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite quanto deseja converter:\n");
        float qtd_convert = scan.nextFloat();
        System.out.println("Total conversão de "+conversion_rates1+" para "+moeda+": "+ qtd_convert * moeda_convert);
        Date data = new Date();

        historico_convercoes("[Base_conversão: "+conversion_rates1 +","+ "Moeda_convertida: "+ moeda+", data: "  + data.toString()+"]");
    }



    public static String get_moeda_conversao() throws IOException, InterruptedException {

        TimeUnit.SECONDS.sleep(1);
        System.out.println("≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛\n"
                +"Escolha qual moeda deseja cotar:\n" +
                "\n" +
                "1 - Peso argentino\n" +
                "\n" +
                "2 - Boliviano boliviano\n" +
                "\n" +
                "3 - Real brasileiro\n" +
                "\n" +
                "4 - Peso chileno\n" +
                "\n" +
                "5 - Peso colombiano\n" +
                "\n" +
                "6 - Dólar americano\n"
                + "\n"+ "≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        boolean op= input >0 && input<=6;
        while (!op){
            input = scan.nextInt();
        }
        switch (input) {
            case 1 -> {
                return "ARS";
            }
            case 2 -> {
                return "BOB";
            }
            case 3 -> {
                return "BRL";
            }
            case 4 -> {
                return "CLP";
            }
            case 5 -> {

                return "COP";
            }
            case 6 -> {
                return "USD";
            }


        }


        return"";
    }
}
