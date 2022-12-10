public class Address {

    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;
    private String complement;
    private String CEP;

    public Address(String country, String state, String city, String neighborhood, String street,
                  String number, String complement, String CEP)
    {
        this.country = country;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.CEP = CEP;
    }

    /**
     * An override of toString that create a new String that contains
     * all the attributes of Address
     * @return a new String
     */
    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();

        output.append(String.format("  Country: %s\n", country));
        output.append(String.format("  State: %s\n", state));
        output.append(String.format("  City: %s\n", city));
        output.append(String.format("  Neighborhood: %s\n", neighborhood));
        output.append(String.format("  Street: %s\n", street));
        output.append(String.format("  Number: %s\n", number));
        output.append(String.format("  Complement: %s\n", complement));
        output.append(String.format("  CEP: %s\n", CEP));

        return output.toString();

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
