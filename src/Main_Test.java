import java.sql.SQLOutput;

public class Main_Test {



    public static void main(String[] args) {
        Output.menu_agency();
        Integer c1 = 40284200;
        Integer c2 = 40284200;

        System.out.println(c1.equals(c2));

        Address home = new Address("BR", "RJ", "RJ", "Algum", "Pernambuco",
                "434", "nenhum", "345232");

        Person owner = new Person("Samuel", "163762", "388443", home);
        Account ac1 = new Account("0001", "1234", owner, 200);

        Account ac2 = new Account("002", "43242", owner, 200);
        Account ac3 = new Account("003", "5442", owner, 200);

        System.out.println(Auxiliars.account_list);

//        Creat.account_CreatorTest(ac1);
//        Creat.account_CreatorTest(ac2);
//        Creat.account_CreatorTest(ac3);

        System.out.println(Auxiliars.account_list); //It`s calling toString in Account
        System.out.println(ac1.toString());

        ac1.deposit(200);
        ac1.withDraw(100);
        System.out.println(ac1.transactions_list.toString());

        System.out.println(ac1.statement_listAsString());
    }
}
