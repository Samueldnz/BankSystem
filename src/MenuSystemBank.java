public class MenuSystemBank {

    private static final double MIN_VALUE = 1.0;
    private static final double MAX_VALUE = 20000.0;

    public static void SystemBank(String agency) {
        while (true) {
            double value = 0;
            Account ac1 = null;
            String acNumber;

//            Account account1 = null;
            switch (Output.menu()) {
                case 1: //creat an account
                    System.out.println("Enter your personal data: ");
                    ac1 = Auxiliary.account_Creator(agency);
                    System.out.println("Successful account creation!");
                    System.out.println(String.format("Your Account number is %s!", ac1.getAcNumber()));
                    break;

                case 2: //withdraw
                    System.out.println("Enter with your account number: ");
                    acNumber = InsideHelpers.get_string();
                    ac1 = Auxiliary.searchAccount(acNumber);

                    if (ac1 != null){
                        System.out.printf("Enter an amount to withdraw: ");
                        value = InsideHelpers.get_double(MIN_VALUE, MAX_VALUE);
                        Output.withDraw_message(ac1.withDraw(value));
                    }else{
                        System.out.println("Account doesn't exist!");
                        //ToDo exception!!
                    }
                    break;

                case 3: //deposit
                    System.out.println("Enter with your account number: ");
                    acNumber = InsideHelpers.get_string();
                    ac1 = Auxiliary.searchAccount(acNumber);

                    if(ac1 != null){
                        System.out.printf("Enter an amount to deposit: ");
                        value = InsideHelpers.get_double(MIN_VALUE, MAX_VALUE);
                        Output.deposit_message(ac1.deposit(value));
                    }else{
                        System.out.println("Account doesn't exist!");
                        //ToDo exception!!
                    }
                    break;

                case 4: //Transfer
                    boolean looping = false;
                    Account acDestiny, acOrigin = null;

                    while(!looping) {

                        System.out.println("Enter with your account number: ");
                        acNumber = InsideHelpers.get_string();
                        acOrigin = Auxiliary.searchAccount(acNumber);

                        if(acOrigin != null){
                            System.out.println("Enter with destiny account number: ");
                            acNumber = InsideHelpers.get_string();
                            acDestiny = Auxiliary.searchAccount(acNumber);

                            if (acDestiny != null) {
                                System.out.println("Enter with an amount to transfer: ");
                                value = InsideHelpers.get_double(MIN_VALUE);
                                Output.transfer_message(acOrigin.transfer(acDestiny, value));
                                looping = true;

                            } else {
                                System.out.println("This account doesn't exist! Enter with a new account number please!");
                                //ToDo exception!!
                            }

                        }else {
                            System.out.println("This account doesn't exist! Enter with a new account number please!");
                            //ToDo exception!!
                        }
                    }
                    break;

                case 5: //Balance
                    System.out.println("Enter with your account number: ");
                    acNumber = InsideHelpers.get_string();
                    ac1 = Auxiliary.searchAccount(acNumber);

                    System.out.printf(("Account details: \n"));
                    System.out.println(ac1.outputBalance());
                    break;

                case 6: //Bank statement
                    System.out.println("Enter with your account number: ");
                    acNumber = InsideHelpers.get_string();
                    ac1 = Auxiliary.searchAccount(acNumber);

                    System.out.printf("Bank Statement:\n\n");
                    System.out.println(ac1.statement_listAsString());
                    break;

                case 7: //Back to agencies
                    return;
            }
        }
    }
}
