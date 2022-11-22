import java.util.ArrayList;
import java.util.Date;
public class Account {
    ArrayList<String> statement_list = new ArrayList<>();
    private static final double MIN_VALUE = 1.0;
    private final String AGENCY;
    private final String AC_NUMBER;
    private Person accountOwner;
    private double balance;

    public Account(String ag, String cc, Person accountOwner, double value){
        this.accountOwner = accountOwner;
        this.AGENCY = ag;
        this.AC_NUMBER = cc;

        deposit(value);
    }

    public boolean withDraw(double value){
        if(value > this.balance || value < MIN_VALUE){  //A negative amount or greater than the balance can`t be withdrawn
            return false;
        }
        this.balance -= value;
        Date now = new Date(); //set a date week mm/dd hour aa
        String transaction = String.format("(" + now + ") Withdraw: R$ %.2f", value);
        statement_list.add(transaction);
        return true;
    }

    private boolean withDrawToTransfer(double value){
        if(value > this.balance || value < MIN_VALUE){
            return false;
        }
        this.balance -= value;
        Date now = new Date(); //set a date week mm/dd hour aa
        String transaction = String.format("(" + now + ") Withdraw to Transfer: R$ %.2f", value);
        statement_list.add(transaction);
        return true;
    }

    public boolean deposit(double value){
        if(value < MIN_VALUE){  //at least R$1,00 is needed to deposit
            return false;
        }
        this.balance += value;
        Date now = new Date(); //set a date week mm/dd hour aa
        String transaction = String.format("(" + now + ") Deposit: R$ %.2f", value);
        statement_list.add(transaction);
        return true;

    }

    public boolean depositToTransfer(double value){
        if(value < MIN_VALUE){  //at least R$1,00 is needed to deposit
            return false;
        }
        this.balance += value;
        Date now = new Date(); //set a date week mm/dd hour aa
        String transaction = String.format("(" + now + ") Deposit from Transfer: R$ %.2f", value);
        statement_list.add(transaction);
        return true;

    }

    public boolean transfer(Account destiny, double value){

        if(!this.withDrawToTransfer(value)){return false;}
        if(!destiny.depositToTransfer(value)){return false;}
        return true;
    }

    public String outputBalance()
    {
        StringBuilder output = new StringBuilder();

        output.append(String.format("    Agency: %s\n", getAgency()));
        output.append(String.format("    Account: %s\n", getAcNumber()));
        output.append(String.format("    Name: %s\n", accountOwner.getName()));
        output.append(String.format("    Balance: %.2f\n", getBalance()));
//        output.append(String.format("Teste: %s \n", accountOwner.getCPF()));
//        output.append(String.format("Teste: %s \n", accountOwner.getAddress1().getCEP()));
        return output.toString();

    }

    public String statement_listAsString (){
        StringBuilder output = new StringBuilder();

        for(String s : statement_list){
            output.append(String.format("%s\n", s));
        }

        return output.toString();
    }

//    public boolean compare_Account(String accountNumber, String password){
//        for(Account ac : Auxiliars.account_list){
//            if(ac.getAcNumber().equals(accountNumber)){
//                if(ac.getPassword().equals(password)){
//                    return true;
//                }return false;     //ToDo throw new RuntimeException("Invalid Password! Try again.");
//            }
//        }
//        return false;
//    }
//   comparador de conta(conta e senha){
//        faz (for) uma busca por conta
//            se  conta for igual
//                faz uma busca por senha
//                    se senha for igual
//                        retorna true, é logado
//                    else senha invalida retorna false
//
//            else conta invalida    retorna false
//    }

    public String getAgency() {
        return AGENCY;
    }
    public String getAcNumber() {
        return AC_NUMBER;
    }
    public double getBalance() {
        return balance;
    }



}

