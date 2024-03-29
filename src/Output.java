import java.security.PublicKey;

public abstract class Output {

    /**
     * Message used in main when the user enter in the System
     */
    public static void welcome_message(){
        System.out.println("\nWelcome to Sampaio Brothers Bank! \n");
    }

    /**
     * Message used in main when the user leave the system
     */
    public static void goodbye_message(){System.out.println("GoodBye! See you soon! \nSampaio Brothers Bank, multiplying your money!");}

    /**
     * Menu used in the first switch in MenuSystemBank to choose what the user will do in his account
     * @return the option chosen
     */
    public static int menu(){
        System.out.printf("Choose an option from the following ones: \n");
        System.out.println("  1) Creat account");
        System.out.println("  2) Withdraw");
        System.out.println("  3) Deposit");
        System.out.println("  4) Transfer");
        System.out.println("  5) Loan");
        System.out.println("  6) Balance");
        System.out.println("  7) Bank statement");
        System.out.println("  8) Edit Personal Data");
        System.out.println("  9) Remove Account");
        System.out.println("  0) Back to Agencies");

        System.out.printf("\nOprtion: ");

        return InsideHelpers.get_Int(0, 9);
    }

    /**
     * It refers to the option inside Edit option, so the user can edit some personal data
     * @return the option chosen
     */
    public static int edit_menu(){
        System.out.printf("Choose an option from the following ones: \n");
        System.out.println("  1) Edit name");
        System.out.println("  2) Edit password");
        System.out.println("  3) Edit Address");
        System.out.println("  4) Confirm");

        System.out.printf("\nOprtion: ");

        return InsideHelpers.get_Int(1, 4);
    }

    /**
     * A menu of confirmation. It confirms an option chosen by the user
     * @return the option chosen
     */
    public static int confirmation(){
        System.out.println("Are you sure? ");
        System.out.println("  1) Yes");
        System.out.println("  2) No");
        System.out.println("Option: ");

        return InsideHelpers.get_Int(1, 2);
    }

    /**
     * The follow methods are built in the same way. All of them are method that print in the terminal if the action was
     * successful
     * @param result a boolean with the result of the action
     */
    public static void withDraw_message(boolean result){
        if(result) {System.out.println("Successful withdrawal!\n");
        }else{System.out.println("You don`t have enough money!\n");}
    }
    public static void deposit_message(boolean result){
        if(result) {System.out.println("Successful deposit!\n");
        }else{System.out.println("Invalid value. Please, enter with an amount over R$1.0\n");}
    }

    public static void transfer_message(boolean result){
        if(result) {System.out.println("Successful Transfer!\n");
        }else{System.out.println("Transfer couldn't be completed. Check your Balance");
        }
    }

    public static void loan_message(boolean result){
        if(result){ System.out.println("Successful loan!");}
        else {System.out.println("You don`t have enough credit!");}
    }
    public static void remove_message(boolean result) {
        if (result) {System.out.println("Successful Remove");
        } else {System.out.println("Account couldn't be removed!");}
    }

    /**
     * A menu of all the possible agencies to chosen. Used in the main
     * @return the agency chosen
     */
    public static int menu_agency(){
        System.out.printf("Choose your agency: \n");
        Strings_Agency.agency_001();
        Strings_Agency.agency_002();
        Strings_Agency.agency_003();
        Strings_Agency.agency_004();
        Strings_Agency.agency_005();
        Strings_Agency.agency_006();
        System.out.println("\n7) Leave Sampaio Brothers Bank");

        System.out.printf("\nOprtion: ");

        return InsideHelpers.get_Int(1, 7);
    }

    /**
     * Print in the terminal all the current personal data of the user before he edit
     * @param ac the user's account
     */
    public static void output_personalData(Account ac){
        System.out.printf(ac.getAccountHolder().toString());
        System.out.println(ac.getAccountHolder().getAddress1().toString());
    }
}
