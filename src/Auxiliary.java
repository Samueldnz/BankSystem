import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public abstract class Auxiliary {

    static Random myRMgenerator = new Random();
    public static HashMap<String, Account> accountByACNumber = new HashMap<>();
    public static HashSet<String> acNumberHash = new HashSet<>();

    private static String number_account;
    private static double firstValue;
    public static Account account_Creator(String agency){
        boolean hasAcNumber;

        String name = InputPersonalData.input_name();
        String CPF = InputPersonalData.input_cpf();
        String ID = InputPersonalData.input_id();
        String country = InputPersonalData.input_country();
        String state = InputPersonalData.input_state();
        String city = InputPersonalData.input_city();
        String neighborhood = InputPersonalData.input_neighborhood();
        String street = InputPersonalData.input_street();
        String number = InputPersonalData.input_number();
        String complement = InputPersonalData.input_complement();
        String CEP = InputPersonalData.input_cep();

        firstValue = InputPersonalData.input_firstValue();

        Address home = new Address(country, state, city, neighborhood, street, number, complement, CEP);
        Person owner = new Person(name, CPF, ID, home);

        do{
            number_account = generator_accountNumber();
            hasAcNumber = searchAcNumber(number_account);
        }while (hasAcNumber);

        acNumberHash.add(number_account);

        Account account1 = new Account(agency, number_account, owner, firstValue);
        accountByACNumber.put(number_account, account1);

        return account1;
    }

    private static boolean searchAcNumber(String number_account) {
        return acNumberHash.contains(number_account);
    }

    private static String generator_accountNumber() { //gerar número de conta aleatório
        return String.valueOf(myRMgenerator.nextLong(000000, 999999));
    }

    public static Account searchAccount(String acNumber){
        return accountByACNumber.get(acNumber);
    }


}
