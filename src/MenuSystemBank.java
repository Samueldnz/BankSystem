public class MenuSystemBank {

    private static final double MIN_VALUE = 1.0;
    private static final double MAX_VALUE = 20000.0;

    public static void SystemBank(String agency) {
        while (true) {
            double value = 0;
            Account ac1 = null;
            String acNumber;
            String password;
            int loginAttempts = 0;
            boolean looping = false;

//            Account account1 = null;
            switch (Output.menu()) {
                case 1: //creat an account
                    System.out.println("Enter your personal data: ");
                    ac1 = Auxiliary.account_Creator(agency);
                    System.out.println("Successful account creation!");
                    System.out.println(String.format("Your Account number is %s!", ac1.getAcNumber()));
                    break;

                case 2: //withdraw

                    while(loginAttempts < 3 && !looping) {
                        System.out.println("Enter with your account number: ");
                        acNumber = InsideHelpers.get_string();
                        loginAttempts++;
                        System.out.print(String.format("Enter with your password (%dº Attempt): \n", loginAttempts));
                        password = InsideHelpers.get_string();

                        if (Auxiliary.Login_verification(acNumber, password)) {
                            System.out.println("Successful Login!");
                            System.out.printf("Enter an amount to withdraw: ");
                            value = InsideHelpers.get_double(MIN_VALUE, MAX_VALUE);
                            Output.withDraw_message(Auxiliary.searchAccount(acNumber).withDraw(value));
                            looping = true;
                        } else {
                            System.out.println("Login Failed!"); //ToDo throw an Exception
                        }
                    }
                    break;

                case 3: //deposit

                    while(loginAttempts < 3 && !looping) {
                        System.out.println("Enter with your account number: ");
                        acNumber = InsideHelpers.get_string();
                        loginAttempts++;
                        System.out.print(String.format("Enter with your password (%dº Attempt): \n", loginAttempts));
                        password = InsideHelpers.get_string();

                        if (Auxiliary.Login_verification(acNumber, password)) {
                            System.out.println("Successful Login!");
                            System.out.printf("Enter an amount to deposit: ");
                            value = InsideHelpers.get_double(MIN_VALUE, MAX_VALUE);
                            Output.deposit_message(Auxiliary.searchAccount(acNumber).deposit(value));
                            looping = true;
                        } else {
                            System.out.println("Login Failed!"); //ToDo throw an Exception
                        }
                    }
                    break;

                case 4: //Transfer
                    Account acDestiny;
                    String acNumbDestiny, acNumbOrigin;

                    while(loginAttempts < 3 && !looping) {

                        System.out.println("Enter with your account number: ");
                        acNumbOrigin= InsideHelpers.get_string();
                        loginAttempts++;
                        System.out.print(String.format("Enter with your password (%dº Attempt): \n", loginAttempts));
                        password = InsideHelpers.get_string();

                        if(Auxiliary.Login_verification(acNumbOrigin, password)){
                            System.out.println("Successful Login!");
                            System.out.println("Enter with destiny account number: ");
                            acNumbDestiny = InsideHelpers.get_string();
                            acDestiny = Auxiliary.searchAccount(acNumbDestiny);

                            if(acDestiny != null){
                                System.out.println("Enter with an amount to transfer: ");
                                value = InsideHelpers.get_double(MIN_VALUE);
                                Output.transfer_message(acDestiny.transfer(acDestiny, value));
                                looping = true;
                            } else {
                                System.out.println("Destiny account doesn't exist! Enter with a new account number please!");
                                //ToDo exception!!
                            }
                        }else {
                            System.out.println("Login Failed");
                            //ToDo exception!!
                        }
                    }
                    break;

                case 5: //Balance
                    while(loginAttempts < 3 && !looping) {
                        System.out.println("Enter with your account number: ");
                        acNumber = InsideHelpers.get_string();
                        loginAttempts++;
                        System.out.print(String.format("Enter with your password (%dº Attempt): \n", loginAttempts));
                        password = InsideHelpers.get_string();

                        if (Auxiliary.Login_verification(acNumber, password)) {
                            System.out.println("Successful Login!");
                            ac1 = Auxiliary.searchAccount(acNumber);
                            System.out.printf(("Account details: \n"));
                            System.out.println(ac1.outputBalance());
                            looping = true;
                        } else {
                            System.out.println("Login Failed!");
                        }
                    }
                    break;

                case 6: //Bank statement
                    while(loginAttempts < 3 && !looping) {
                        System.out.println("Enter with your account number: ");
                        acNumber = InsideHelpers.get_string();
                        loginAttempts++;
                        System.out.print(String.format("Enter with your password (%dº Attempt): \n", loginAttempts));
                        password = InsideHelpers.get_string();

                        if (Auxiliary.Login_verification(acNumber, password)) {
                            System.out.println("Successful Login!");
                            ac1 = Auxiliary.searchAccount(acNumber);
                            System.out.printf("Bank Statement:\n\n");
                            System.out.println(ac1.statement_listAsString());
                            looping = true;
                        } else {
                            System.out.println("Login failed!");
                        }
                    }
                    break;

                case 7: //edit personal data
                    String newName, newPassword, country, state, city, neighborhood, street, number, complement, CEP;

                    while(loginAttempts < 3 && !looping) {

                        System.out.println("Enter with your account number: ");
                        acNumber = InsideHelpers.get_string();
                        loginAttempts++;
                        System.out.print(String.format("Enter with your password (%dº Attempt): \n", loginAttempts));
                        password = InsideHelpers.get_string();

                        if (Auxiliary.Login_verification(acNumber, password)) {
                            ac1 = Auxiliary.searchAccount(acNumber);

                            while(!looping) {

                                System.out.println("Your personal data: ");
                                Output.output_personalData(ac1);

                                switch (Output.edit_menu()) {
                                    case 1: //nome
                                        System.out.println("Enter with your new name: ");
                                        newName = InputPersonalData.input_name();
                                        switch (Output.confirmation()){
                                            case 1: //yes
                                                EditData.edit_Name(ac1, newName);
                                                System.out.println("Successful edit!");
                                                break;

                                            case 2: //cancel
                                                System.out.println("Edit canceled!");
                                                break;
                                        }
                                        break;


                                    case 2: //password
                                        System.out.println("Enter your new password: ");
                                        newPassword = InputPersonalData.input_password();

                                        switch (Output.confirmation()){
                                            case 1: //yes
                                                EditData.edit_Password(ac1, newPassword);
                                                System.out.println("Successful edit!");
                                                break;

                                            case 2: //cancel
                                                System.out.println("Edit canceled!");
                                                break;
                                        }
                                        break;

                                    case 3: //address

                                        System.out.println("Enter with your new address: ");
                                        Address adrss = Auxiliary.creat_newAddress();

                                        switch (Output.confirmation()){
                                            case 1: //yes
                                                EditData.edit_Address(ac1, adrss);
                                                System.out.println("Successful edit!");
                                                break;

                                            case 2: //cancel
                                                System.out.println("Edit canceled!");
                                                break;
                                        }
                                        break;

                                    case 4: //confirm
//                                        ac1 = Auxiliary.searchAccount(acNumber);
//                                        switch (Output.confirmation()) {
//                                            case 1:
//                                                EditData.edit_Name(ac1, newName);
//                                                EditData.edit_Password(ac1, newPassword);
//                                                EditData.edit_Address(ac1, country, state, city, neighborhood, street, number,
//                                                        complement, CEP);
//                                                System.out.println("Successful edit!");
//                                                looping = true;
//                                                break;
//                                            case 2:
//                                                System.out.println("Edit was canceled!");
//                                                looping = true;
//                                                break;
//                                        }
                                        looping = true;
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Login failed!");
                        }
                    }
                    break;

                case 8: //remove

                    switch (Output.confirmation()) {
                        case 1:
                            while (loginAttempts < 3 && !looping) {
                                System.out.println("Enter with your account number: ");
                                acNumber = InsideHelpers.get_string();
                                loginAttempts++;
                                System.out.print(String.format("Enter with your password (%dº Attempt): \n", loginAttempts));
                                password = InsideHelpers.get_string();

                                if (Auxiliary.Login_verification(acNumber, password)) {
                                    ac1 = Auxiliary.searchAccount(acNumber);
                                    Output.remove_message(ac1.remove_Account());
                                    looping = true;
                                } else {
                                    System.out.println("Login Failed!");
                                }
                            }
                            break;

                        case 2:
                            System.out.println("Action canceled!");
                            break;
                    }
                    break;

                case 9: //Back to agencies
                    return;
            }
        }
    }
}
