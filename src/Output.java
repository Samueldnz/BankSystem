public abstract class Output {

    public static void welcome_message(){
        System.out.println("\nWelcome to Sampaio Brothers Bank! \n");
    }

    public static void goodbye_message(){System.out.println("GoodBye! See you soon! \nSampaio Brothers Bank, multiplying your money!");}
    public static int menu(){
        System.out.printf("Choose an option from the following ones: \n");
        System.out.println("  1) Creat account");
        System.out.println("  2) Withdraw");
        System.out.println("  3) Deposit");
        System.out.println("  4) Transfer");
        System.out.println("  5) Balance");
        System.out.println("  6) Bank statement");
        System.out.println("  7) Edit Personal Data");
        System.out.println("  8) Remove Account");
        System.out.println("  9) Back to Agencies");

        System.out.printf("\nOprtion: ");
        int option = InsideHelpers.get_Int(1, 9);  //exception if I put a letter

        return option;
    }

    public static int edit_menu(){
        System.out.printf("Choose an option from the following ones: \n");
        System.out.println("  1) Edit name");
        System.out.println("  2) Edit password");
        System.out.println("  3) Edit Address");
        System.out.println("  4) Confirm");

        System.out.printf("\nOprtion: ");
        int option = InsideHelpers.get_Int(1, 4);  //exception if I put a letter

        return option;
    }

    public static int confirmation(){
        System.out.println("Are you sure? ");
        System.out.println("  1) Yes");
        System.out.println("  2) No");
        System.out.println("Option: ");
        int option = InsideHelpers.get_Int(1, 2);

        return option;
    }

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
    public static void remove_message(boolean result) {
        if (result) {System.out.println("Successful Remove");
        } else {System.out.println("Account couldn't be removed!");}
    }

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
        int option_agency = InsideHelpers.get_Int(1, 7);  //exception if I put a letter

        return option_agency;
    }
}
