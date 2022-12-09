import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Output.welcome_message();

        while(true){
            switch (Output.menu_agency()){
                case 1:
                    MenuSystemBank.SystemBank(AgencyType.A001);
                    break;
                case 2:
                    MenuSystemBank.SystemBank(AgencyType.A002);
                    break;
                case 3:
                    MenuSystemBank.SystemBank(AgencyType.A003);
                    break;
                case 4:
                    MenuSystemBank.SystemBank(AgencyType.A004);
                    break;
                case 5:
                    MenuSystemBank.SystemBank(AgencyType.A005);
                    break;
                case 6:
                    MenuSystemBank.SystemBank(AgencyType.A006);
                    break;
                case 7: //leave
                    Output.goodbye_message();
                    return;
            }
        }
    }
}