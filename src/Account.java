import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
public class Account {
    ArrayList<String> statement_list = new ArrayList<>();
    private static final double MIN_VALUE = 1.0;
    private static final double CREDIT_INCREASE = 0.00010; //same as 0.01%
    private static final double ZERO = 0.0;
    private final String AGENCY;
    private final String AC_NUMBER;
    private Person accountOwner;
    private double balance;
    private long passwordHash;
    private static double loanCredit;
    private double loanDebit;

    public Account(String ag, String cc, Person accountOwner, String password, double value){
        this.accountOwner = accountOwner;
        this.AGENCY = ag;
        this.AC_NUMBER = cc;
        this.passwordHash = password.hashCode();
        this.loanDebit = ZERO;
        deposit(value);
        loanCredit = ZERO;
    }

    public boolean withDraw(double value){
        if(value > this.balance || value < MIN_VALUE){  //A negative amount or greater than the balance can`t be withdrawn
            return false;
        }
        this.balance -= value;
        Date now = new Date(); //set a date week mm/dd hour aa
        String transaction = String.format("(" + now + ") Withdraw: R$ %.2f", value);
        statement_list.add(transaction);
        loanCredit += CREDIT_INCREASE;
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
        loanCredit += CREDIT_INCREASE;
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
        loanCredit += CREDIT_INCREASE;
        return true;
    }

    public boolean loan(double value){
        if(loanCredit < 0.01 || value < MIN_VALUE || loanCredit * this.balance < value) return false;

        this.loanDebit += value;
        loanCredit += 10 * CREDIT_INCREASE;
        return true;
    }


    public String outputBalance()
    {
        StringBuilder output = new StringBuilder();

        output.append(String.format("    Agency: %s\n", getAgency()));
        output.append(String.format("    Account Number: %s\n", getAcNumber()));
        output.append(String.format("    Name: %s\n", accountOwner.getName()));
        output.append(String.format("    CPF: %s\n", accountOwner.getCPF()));
        output.append(String.format("    Credit of loan: %.4f\n", getLoanCredit()));
        output.append(String.format("    Debit to pay: %.2f\n", getLoanDebit()));
        output.append(String.format("    Balance: %.2f\n", getBalance()));
        return output.toString();

    }


    public String statement_listAsString (){
        StringBuilder output = new StringBuilder();

        for(String s : statement_list){
            output.append(String.format("%s\n", s));
        }

        return output.toString();
    }

    public boolean remove_Account() {
        if(this.balance == 0){
            Auxiliary.getAccountByACNumber().remove(this.AC_NUMBER);
            return true;
        }
        return false;
    }

//    public int remove_AccountAlternative(){
//        if(this.balance > 0){
//            System.out.println("You need to withdraw your money first!");
//            return 1;
//        } else if (this.balance < 0) {
//            System.out.println("You need to pay your debt first!");
//            return -1;
//        }else{
//            accountByACNumber.remove(this.AC_NUMBER);
//            return 0;
//        } //ToDo implement me with an Exception (maybe)
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
    public long getPasswordHash() {
        return passwordHash;
    }

    public Person getAccountOwner() {
        return accountOwner;
    }

    public void setPasswordHash(long passwordHash) {
        this.passwordHash = passwordHash;
    }

    public double getLoanCredit() {
        return loanCredit;
    }

    public double getLoanDebit() {
        return loanDebit;
    }


}

