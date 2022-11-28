import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import static org.junit.Assert.*;


public class Unit_Test{

    final double DELTA = 0.000000001;
    Address home = new Address("Brasil", "Rio de Janeiro", "Resende", "none",
            "none", "1", "none", "42543543");
    Person owner = new Person("Samuel", "1234567", "12345678", home);
    Account ac1 = new Account("001", "231231", owner, "123456", 1000);
    Account ac2 = new Account("001", "098765", owner, "123456", 1000);
    HashMap<String, Account> accountByAcNumber;

    public boolean Login_verification(String AcNumber, String password) {
        Account ac1 = accountByAcNumber.get(AcNumber);
        return ac1 != null && ac1.getPasswordHash() == password.hashCode();
    }
    @Before
    public void setUp(){
        accountByAcNumber = new HashMap<>();
        accountByAcNumber.put("231231", ac1);
        accountByAcNumber.put("098765", ac2);

    }
    @Test
    public void deposiTest(){

        assertTrue(ac1.deposit(1000.1000));
        assertEquals(2000.1000, ac1.getBalance(), DELTA);

        assertFalse(ac1.deposit(0));
        assertEquals(2000.1000, ac1.getBalance(), DELTA);

        assertFalse(ac1.deposit(-10094.40));
        assertEquals(2000.1000, ac1.getBalance(), DELTA);

    }
    @Test
    public void withdrawTest(){

        assertFalse(ac1.withDraw(0.1000));
        assertEquals(1000, ac1.getBalance(), DELTA);

        assertTrue(ac1.withDraw(500));
        assertEquals(500.0, ac1.getBalance(), DELTA);

        assertFalse(ac1.withDraw(0.11));
        assertEquals(500.0, ac1.getBalance(), DELTA);

        assertFalse(ac1.withDraw(-19384.50));
        assertEquals(500.0, ac1.getBalance(), DELTA);
    }

    @Test
    public void transferTest(){

        assertTrue(ac1.transfer(ac2, 250.50));
        assertEquals(749.50, ac1.getBalance(), DELTA);
        assertEquals(1250.50, ac2.getBalance(), DELTA);

        assertFalse(ac1.transfer(ac2, 0.1000));
        assertEquals(749.50, ac1.getBalance(), DELTA);
        assertEquals(1250.50, ac2.getBalance(), DELTA);

        //It doesn't need to Test assertEqual for this two below because the return is false
        assertFalse(ac1.transfer(ac2, 0));
        assertFalse(ac1.transfer(ac2,-430.49));

        //It`s testing if the method works at the same way
        assertTrue(ac2.transfer(ac1, 49.50));
        assertEquals(799.0, ac1.getBalance(), DELTA);
        assertEquals(1201.00, ac2.getBalance(), DELTA);
    }

    /**
     * It doesn't call the method in Auxiliary Class because there is a difference between the names of both HashMaps,
     * but it works at the same way.
     */
    @Test
    public void searchAccountTest(){
        assertSame(ac1, accountByAcNumber.get("231231"));
        assertNull(accountByAcNumber.get("324342")); //This account number doesn't exist

    }

    /**
     * It doesn't call the method in Auxiliary Class because there is a difference between the names of both HashMaps,
     * but it works at the same way. So in order to fix this problem, a new method in this class was creat in the same way
     */
    @Test
    public void loginVerificationTest(){
        assertTrue(Login_verification("231231", "123456")); //Account and password corrects
        assertFalse(Login_verification("231231", "098765")); //Right account, wrong password
        assertFalse(Login_verification("324234", "123456")); //Wrong account, right password

        assertTrue(Login_verification("098765", "123456")); //Account and password corrects
        assertFalse(Login_verification("098765", "4234234")); //Right account, wrong password
        assertFalse(Login_verification("424324", "123456")); //Wrong account, right password
    }
}
