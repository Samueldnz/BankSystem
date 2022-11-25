public abstract class InputPersonalData {
    private static String name;
    private static String cpf;
    private static String id;
    private static String country;
    private static String state;
    private static String city;
    private static String neighborhood;
    private static String street;
    private static String number;
    private static String complement;
    private static String cep;

    public static String input_name(){
        System.out.printf("  Name: ");
        name = InsideHelpers.get_string();
        return name;
    }

    public static String input_cpf(){
        System.out.printf("  CPF: ");
        cpf = InsideHelpers.get_string();
        return cpf;
    }

    public static String input_id(){
        System.out.printf("  ID: ");
        id = InsideHelpers.get_string();
        return id;
    }

    public static String input_country(){
        System.out.printf("  Country: ");
        country = InsideHelpers.get_string();
        return country;
    }

    public static String input_state(){
        System.out.printf("  State: ");
        state = InsideHelpers.get_string();
        return state;
    }
    public static String input_city(){
        System.out.printf("  City: ");
        city = InsideHelpers.get_string();
        return city;
    }

    public static String input_neighborhood() {
        System.out.printf("  Neighborhoood: ");
        neighborhood = InsideHelpers.get_string();
        return neighborhood;
    }

    public static String input_street() {
        System.out.printf("  Street: ");
        street = InsideHelpers.get_string();
        return street;
    }

    public static String input_number() {
        System.out.printf("  House number: ");
        number = InsideHelpers.get_string();
        return number;
    }

    public static String input_complement() {
        System.out.printf("  Complement: ");
        complement = InsideHelpers.get_string();
        return complement;
    }

    public static String input_cep() {
        System.out.printf("  CEP: ");
        cep = InsideHelpers.get_string();
        return cep;
    }

    public static double input_firstValue(){
        System.out.println("Enter your first value to deposit: ");
        double value = InsideHelpers.get_double(1.0);
        return value;
    }

}
