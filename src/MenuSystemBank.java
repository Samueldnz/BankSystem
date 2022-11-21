public class MenuSystemBank {

    private static final double MIN_VALUE = 1.0;
    private static final double MAX_VALUE = 20000.0;
    private static Account account1 = null;

    public static void SystemBank(String agency) {
        while (true) {
            double value = 0;

//            Account account1 = null;
            switch (Output.menu()) {
                case 1: //creat an account
                    System.out.println("Enter your personal data: ");
                    account1 = Auxiliars.account_Creator(agency);
                    System.out.println("Successful account creation!");
                    break;

                case 2: //withdraw
                    System.out.printf("Enter an amount to withdraw: ");
                    value = InsideHelpers.get_double(MIN_VALUE, MAX_VALUE);
                    Output.withDraw_message(account1.withDraw(value));
                    break;

                case 3: //deposit
                    System.out.printf("Enter an amount to deposit: ");
                    value = InsideHelpers.get_double(MIN_VALUE, MAX_VALUE);
                    Output.deposit_message(account1.deposit(value));
                    break;

                case 4: //Transfer
                    boolean looping = true;
                    while(looping) {

                        System.out.println("Enter with destiny account number: ");
                        InsideHelpers.get_string();
                        String acNumber = InsideHelpers.get_string();
                        Account ac1 = Auxiliars.searchAccount(acNumber);

                        if (Auxiliars.account_list.contains(ac1)) {
                            System.out.println("Enter with an amount to transfer: ");
                            value = InsideHelpers.get_double(MIN_VALUE);
                            Output.transfer_message(account1.transfer(ac1, value));
                            looping = false;

                        } else {System.out.println("This account doesn't exist!");}
                    }
                    break;

                case 5: //Balance
                    System.out.println(account1.toString());
                    break;

                case 6: //Bank statement
                    System.out.printf("Bank Statement:\n\n");
                    System.out.println(account1.statement_listAsString());
                    break;

                case 7: //Back to agencies
                    return;
            }
        }
    }
}
