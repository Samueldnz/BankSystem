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
