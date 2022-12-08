import org.jetbrains.annotations.NotNull;

public abstract class EditData {

    public static void edit_Name(@NotNull Account ac1, String newName){
        ac1.getAccountOwner().setName(newName);
    }

    public static void edit_Password(@NotNull Account ac1, @NotNull String password){
        ac1.setPasswordHash(password.hashCode());
    }

    public static void edit_Address(@NotNull Account ac1, Address newAddress){
        ac1.getAccountOwner().setAddress1(newAddress);
    }

}
