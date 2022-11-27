import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public abstract class Auxiliary {

    static Random myRMgenerator = new Random();
    public static HashMap<String, Account> accountByACNumber = new HashMap<>();
    public static HashSet<String> acNumberHash = new HashSet<>();


    public static Account account_Creator(String agency){

        String name = InputPersonalData.input_name();
        String CPF = InputPersonalData.input_cpf();
        String ID = InputPersonalData.input_id();
        String password = InputPersonalData.input_password();
        String country = InputPersonalData.input_country();
        String state = InputPersonalData.input_state();
        String city = InputPersonalData.input_city();
        String neighborhood = InputPersonalData.input_neighborhood();
        String street = InputPersonalData.input_street();
        String number = InputPersonalData.input_number();
        String complement = InputPersonalData.input_complement();
        String CEP = InputPersonalData.input_cep();

        double firstValue = InputPersonalData.input_firstValue();

        Address home = new Address(country, state, city, neighborhood, street, number, complement, CEP);
        Person owner = new Person(name, CPF, ID, home);

        String number_account = generator_accountNumber();

        Account account1 = new Account(agency, number_account, owner, password, firstValue);
        accountByACNumber.put(number_account, account1);

        return account1;
    }

    private static boolean searchAcNumber(String number_account) {
        return acNumberHash.contains(number_account);
    }

    private static String generator_accountNumber() { //gerar número de conta aleatório
        boolean hasAcNumber;
        String s;

        do{
            s = String.valueOf(myRMgenerator.nextLong(000000, 999999));
            hasAcNumber = searchAcNumber(s);
        }while(hasAcNumber);

        acNumberHash.add(s);

        return s;
    }

    public static Account searchAccount(String acNumber){
        return accountByACNumber.get(acNumber);
    }

    public static boolean Login_verification(String AcNumber, String password){
        Account ac1 = accountByACNumber.get(AcNumber);

        if(ac1 != null){
            if(ac1.getPasswordHash() == password.hashCode()){
                return true;
            }
        }
        return false;
    }


}
