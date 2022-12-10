public abstract class InputPersonalData {

    // methods that catch from the keyboard strings and other personal data to creat the objects
    public static String input_name(){
        System.out.printf("  Name: ");
        String name = InsideHelpers.get_string();
        return name;
    }

    public static String input_cpf(){
        System.out.printf("  CPF: ");
        String cpf = InsideHelpers.get_string();
        return cpf;
    }

    public static String input_id(){
        System.out.printf("  ID: ");
        String id = InsideHelpers.get_string();
        return id;
    }

    public static String input_country(){
        System.out.printf("  Country: ");
        String country = InsideHelpers.get_string();
        return country;
    }

    public static String input_state(){
        System.out.printf("  State: ");
        String state = InsideHelpers.get_string();
        return state;
    }
    public static String input_city(){
        System.out.printf("  City: ");
        String city = InsideHelpers.get_string();
        return city;
    }

    public static String input_neighborhood() {
        System.out.printf("  Neighborhoood: ");
        String neighborhood = InsideHelpers.get_string();
        return neighborhood;
    }

    public static String input_street() {
        System.out.printf("  Street: ");
        String street = InsideHelpers.get_string();
        return street;
    }

    public static String input_number() {
        System.out.printf("  House number: ");
        String number = InsideHelpers.get_string();
        return number;
    }

    public static String input_complement() {
        System.out.printf("  Complement: ");
        String complement = InsideHelpers.get_string();
        return complement;
    }

    public static String input_cep() {
        System.out.printf("  CEP: ");
        String cep = InsideHelpers.get_string();
        return cep;
    }

    public static String input_password(){
        System.out.println("  Password (6 digits): ");
        String psswrd = InsideHelpers.get_string();

        while(psswrd.length() != 6){
            System.out.println("Invalid Password! Try again!");
            psswrd = InsideHelpers.get_string();
        }
        return psswrd;
    }

    public static double input_firstValue(){
        System.out.println("Enter your first value to deposit: ");
        double value = InsideHelpers.get_double(1.0);
        return value;
    }


}
