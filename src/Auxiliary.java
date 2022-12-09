import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


public abstract class Auxiliary {

    static Random myRMgenerator = new Random();
    private static HashMap<String, Account> accountByACNumber = new HashMap<>();
    private static HashSet<String> acNumberHash = new HashSet<>();


    public static Account account_Creator(AgencyType agency) {

        Person owner = creat_newPerson(creat_newAddress());

        String password = InputPersonalData.input_password();
        double firstValue = InputPersonalData.input_firstValue();

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

        char c = (char) (myRMgenerator.nextInt(26) + 'a');

        do {
            s = c + String.valueOf(myRMgenerator.nextLong(000000, 999999)); //char low case
            hasAcNumber = searchAcNumber(s);
        } while (hasAcNumber);

        acNumberHash.add(s);

        return s.toUpperCase(); //char UpperCase
    }

    public static Account searchAccount(String acNumber) {
        return accountByACNumber.get(acNumber);
    }

    public static boolean Login_verification(String AcNumber, String password) {
        Account ac1 = accountByACNumber.get(AcNumber);
        return ac1 != null && ac1.getPasswordHash() == password.hashCode();
    }

    public static Person creat_newPerson(Address address1){
        String name = InputPersonalData.input_name();
        String CPF = InputPersonalData.input_cpf();
        String ID = InputPersonalData.input_id();

        return new Person(name, CPF, ID, address1);
    }

    public static Address creat_newAddress(){

        String country = InputPersonalData.input_country();
        String state = InputPersonalData.input_state();
        String city = InputPersonalData.input_city();
        String neighborhood = InputPersonalData.input_neighborhood();
        String street = InputPersonalData.input_street();
        String number = InputPersonalData.input_number();
        String complement = InputPersonalData.input_complement();
        String CEP = InputPersonalData.input_cep();

        return new Address(country, state, city, neighborhood, street, number, complement, CEP);
    }

    public static HashMap<String, Account> getAccountByACNumber() {
        return accountByACNumber;
    }

    public static HashSet<String> getAcNumberHash() {
        return acNumberHash;
    }
}
