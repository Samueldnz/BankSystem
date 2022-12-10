import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;


public abstract class Auxiliary {

    static Random myRMgenerator = new Random();
    /**
     * A HashMap to hold all the accounts created and make easier the process to search for it. The key is a String
     * with the account number and the value is an object Account
     */
    private static HashMap<String, Account> accountByACNumber = new HashMap<>();

    /**
     * A HashSet that keep safe all the account number that once was generated
     */
    private static HashSet<String> acNumberHash = new HashSet<>();

    /**
     * An Auxiliary method that calls other functions to create an object Account.
     * @param agency receive an Enum that contains an agency
     * @return the object Account
     */
    public static Account account_Creator(AgencyType agency) {

        Person holder = creat_newPerson(creat_newAddress());

        String password = InputPersonalData.input_password();
        double firstValue = InputPersonalData.input_firstValue();

        String number_account = generator_accountNumber();

        Account account1 = new Account(agency, number_account, holder, password, firstValue);
        accountByACNumber.put(number_account, account1);

        return account1;
    }

    /**
     * It checks if there's already an account number in the HashSet
     * @param number_account the number account that is needed to be checked
     * @return true or false
     */
    private static boolean searchAcNumber(String number_account) {
        return acNumberHash.contains(number_account);
    }

    /**
     * It generates an account number and then checks if the searchAcNumber method if that number already exist
     * @return account number in upperCase because there's a letter in the beginning of it
     */
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

    /**
     *
     * @param acNumber receive the account number to check if there's an account with that number
     * @return if it exists, returns the account that was found
     */
    public static Account searchAccount(String acNumber) {
        return accountByACNumber.get(acNumber);
    }

    /**
     * Checks if the password match with the account number passed by the user
     * @param AcNumber account number
     * @param password password of the account
     * @return
     */
    public static boolean Login_verification(String AcNumber, String password) {
        Account ac1 = accountByACNumber.get(AcNumber);
        return ac1 != null && ac1.getPasswordHash() == password.hashCode();
    }

    /**
     * Get from the keyboard all the personal data to build an object person
     * @param address1 receive an object address, this is the address of the person
     * @return an object Person
     */
    public static Person creat_newPerson(Address address1){
        String name = InputPersonalData.input_name();
        String CPF = InputPersonalData.input_cpf();
        String ID = InputPersonalData.input_id();

        return new Person(name, CPF, ID, address1);
    }

    /**
     * Get from the keyboard all the personal data to build an object address
     * @return an object Address
     */
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
