public class Main_Test {



    public static void main(String[] args) {
//        Output.menu_agency();
//        Integer c1 = 40284200;
//        Integer c2 = 40284200;
//
//        System.out.println(c1.equals(c2));

        Address home = new Address("BR", "RJ", "RJ", "Algum", "Pernambuco",
                "434", "nenhum", "345232");

        Person owner = new Person("Samuel", "163762", "388443", home);
        Account ac1 = new Account("0001", "1234", owner, 200);

        Account ac2 = new Account("002", "43242", owner, 200);
        Account ac3 = new Account("003", "5442", owner, 200);
        Auxiliary.account_list.add(ac1);
        Auxiliary.account_list.add(ac2);
        Auxiliary.account_list.add(ac3);


        Account testSearch = Auxiliary.searchAccount("43242");
        System.out.println(testSearch.outputBalance());

//        System.out.println(Auxiliars.account_list);

//        Creat.account_CreatorTest(ac1);
//        Creat.account_CreatorTest(ac2);
//        Creat.account_CreatorTest(ac3);

        System.out.println(Auxiliary.account_list); //It`s calling toString in Account
        System.out.println(ac1.outputBalance());

        ac1.deposit(200);
        ac1.withDraw(100);
        System.out.println(ac1.statement_list.toString());
        //The first one is just printing the array, the second one has format
        System.out.println(ac1.statement_listAsString());
    }
}
