import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import static org.junit.Assert.*;


public class Unit_Test{

    final double DELTA = 0.000000001;
    Address home;
    Person owner;
    Account ac1;
    Account ac2;
    HashMap<String, Account> accountByAcNumber;

    public boolean Login_verification(String AcNumber, String password) {
        Account ac1 = accountByAcNumber.get(AcNumber);
        return ac1 != null && ac1.getPasswordHash() == password.hashCode();
    }
    @Before
    public void setUp(){
        home = new Address("Brasil", "Rio de Janeiro", "Resende", "none",
                "none", "1", "none", "42543543");
        owner = new Person("Samuel", "1234567", "12345678", home);
        ac1 = new Account(AgencyType.A001, "231231", owner, "123456", 1000);
        ac2  = new Account(AgencyType.A001, "098765", owner, "123456", 1000);

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

        //It`s testing if the method works at the same way to ac2
        assertTrue(ac2.transfer(ac1, 49.50));
        assertEquals(799.0, ac1.getBalance(), DELTA);
        assertEquals(1201.00, ac2.getBalance(), DELTA);

        //Checking if it's possible to transfer an amount bigger than the balance
        assertFalse(ac1.transfer(ac2, 900));
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

    @Test
    public void editDataTest(){
        EditData.edit_Name(ac1, "Carlos");
        assertEquals("Carlos", ac1.getAccountOwner().getName());

        EditData.edit_Password(ac1, "436534");
        assertEquals("436534".hashCode(), ac1.getPasswordHash());

        Address testAddss = new Address(" ", " ", " ", " ", " ", " ",
                " ", " ");
        EditData.edit_Address(ac1, testAddss);
        assertEquals(testAddss, ac1.getAccountOwner().getAddress1());


        assertNotEquals("Paulo", ac2.getAccountOwner().getName());
        assertNotEquals("423423".hashCode(), ac2.getPasswordHash());

    }

    @Test
    public void loanTest(){
        //loanCredit = 0.0
        assertFalse(ac1.loan(1000));
        assertFalse(ac1.loan(0.323));
        assertFalse(ac1.loan(90.0938));

        ac1.deposit(1000); //true
        ac1.withDraw(500); //true
        ac1.transfer(ac2, 250); //true
        //loanCredit = 0.0003
        assertFalse(ac1.loan(400));
        assertFalse(ac1.loan(0.08));
        assertFalse(ac1.loan(0.005));
        //loanCredit is still less than 1%

        for(int i = 0; i < 100; i++){
            ac1.deposit(10);
        } //in the end, loanCredit will be 0.0103

        assertFalse(ac1.loan(28));
        assertTrue(ac1.loan(20));
        assertEquals(20, ac1.getLoanDebit(), DELTA);
        //loanCredit = 0.0113

        for(int i = 0; i < 100; i++){
            ac1.loan(20);
        }//in the end, loanCredit will be 0.113
        assertEquals(2020, ac1.getLoanDebit(), DELTA);

        assertFalse(ac1.loan(300));
        assertTrue(ac1.loan(200));
        assertEquals(2220, ac1.getLoanDebit(), DELTA);

        assertFalse(ac1.loan(-150));
        assertFalse(ac1.loan(0));


    }
    @Test
    public void loanCreditTest(){

        ac1.deposit(1000.1000); //true
        ac1.deposit(0); //false
        ac1.deposit(-10094.40); //false
        assertEquals(0.0001, ac1.getLoanCredit(), DELTA);

        ac1.withDraw(0.1000); //false
        ac1.withDraw(500); //true
        ac1.withDraw(0.11); //false
        assertEquals(0.0002, ac1.getLoanCredit(), DELTA);

        ac1.transfer(ac2, 0); //false
        ac1.transfer(ac2, 0.1000); //false
        ac1.transfer(ac2, 250.50); //true
        assertEquals(0.0003, ac1.getLoanCredit(), DELTA);

    }
}
