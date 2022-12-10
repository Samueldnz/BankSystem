public class Person{

    private String name;
    private final String CPF;
    private final String ID;
    private Address address1;

    public Person(String name, String CPF, String ID, Address address1)
    {
        this.address1 = address1;
        this.name = name;
        this.CPF = CPF;
        this.ID = ID;

    }

    /**
     * An override of toString that create a new String that contains
     * all the attributes of Person
     * @return a new String
     */
    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();

        output.append(String.format("  Name: %s\n", name));
        output.append(String.format("  CPF: %s\n", CPF));
        output.append(String.format("  ID: %s\n", ID));

        return output.toString();

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return CPF;
    }

    public String getID() {
        return ID;
    }

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }
}
