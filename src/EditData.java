import org.jetbrains.annotations.NotNull;

public abstract class EditData {

    /**
     * It edits the name of the account holder
     * @param ac1 an object Account that will be edited
     * @param newName the new name to edit
     */
    public static void edit_Name(@NotNull Account ac1, String newName){
        ac1.getAccountHolder().setName(newName);
    }

    /**
     * It edits the password of the account
     * @param ac1 an object Account that will be edited
     * @param password the new password
     */
    public static void edit_Password(@NotNull Account ac1, @NotNull String password){
        ac1.setPasswordHash(password.hashCode());
    }

    /**
     * It edits the address of the account holder
     * @param ac1 an object Account that will be edited
     * @param newAddress the new address
     */
    public static void edit_Address(@NotNull Account ac1, Address newAddress){
        ac1.getAccountHolder().setAddress1(newAddress);
    }

}
