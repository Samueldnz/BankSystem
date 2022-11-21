import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Output.welcome_message();

        while(true){
            switch (Output.menu_agency()){
                case 1:
                    MenuSystemBank.SystemBank("001");
                    break;
                case 2:
                    MenuSystemBank.SystemBank("002");
                    break;
                case 3:
                    MenuSystemBank.SystemBank("003");
                    break;
                case 4:
                    MenuSystemBank.SystemBank("004");
                    break;
                case 5:
                    MenuSystemBank.SystemBank("005");
                    break;
                case 6:
                    MenuSystemBank.SystemBank("006");
                    break;
                case 7: //leave
                    Output.goodbye_message();
                    return;
            }
        }
    }
}