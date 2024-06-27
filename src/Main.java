import moeda.Moeda;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Main extends Conversor_moeda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        Moeda m = new Moeda();
        boolean c = true;


            while (c==true){
            TimeUnit.SECONDS.sleep(1);

            System.out.println(
                            "≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛\n\n"+
                            "Digite a moeda que deseja converter:\n"+
                            "\n"+
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
                            +"\n"+
                            "7 - Histórico\n"+
                                     "\n8 - Sair\n"+
                            "≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛≛");
            int input = scan.nextInt();
            String json;
            switch (input){

                case (1):

                   String valor=  get_moeda_conversao();
                   json = consumir_API(valor);


                    continue;




                case(2):
                    json = consumir_API("BOB");
                    get_Obj_Json(json);
                    continue;

                case(3):
                    json = consumir_API("BRL");
                    get_Obj_Json(json);
                    continue;

                case(4):
                    json = consumir_API("CLP");
                    get_Obj_Json(json);
                    continue;

                case(5):
                    json = consumir_API("COP");
                    get_Obj_Json(json);
                    continue;

                case(6):
                    json = consumir_API("USD");
                    get_Obj_Json(json);
                    continue;


                case(7):
                    System.out.println(getHistorico());
                    continue;

                case(8):

                    System.out.println(
                            "\n(>‿◠) ✌\n"
                                    +
                                    "\nAplicação finalizada.\n");
                    c = false;
                    break;

                default:
                    System.out.println("Digite uma opção válida!\n");
                    TimeUnit.SECONDS.sleep(1);



            }

        }

    }
}
