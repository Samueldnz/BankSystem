import org.jetbrains.annotations.NotNull;

public abstract class EditData {

    public static void edit_Name(@NotNull Account ac1, String newName){
        ac1.getAccountOwner().setName(newName);
    }

    public static void edit_Password(@NotNull Account ac1, String password){
        ac1.setPasswordHash(password.hashCode());
    }

    public static void edit_Address(@NotNull Account ac1, String country, String state, String city, String neighborhood,
                                    String street, String number, String complement, String cep){

        ac1.getAccountOwner().getAddress1().setCountry(country);
        ac1.getAccountOwner().getAddress1().setState(state);
        ac1.getAccountOwner().getAddress1().setCity(city);
        ac1.getAccountOwner().getAddress1().setNeighborhood(neighborhood);
        ac1.getAccountOwner().getAddress1().setStreet(street);
        ac1.getAccountOwner().getAddress1().setNumber(number);
        ac1.getAccountOwner().getAddress1().setComplement(complement);
        ac1.getAccountOwner().getAddress1().setCEP(cep);
    }

}
