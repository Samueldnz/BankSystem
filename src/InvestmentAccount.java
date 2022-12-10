import java.util.ArrayList;
import java.util.Date;

public class InvestmentAccount {

    ArrayList<String> statement_list = new ArrayList<>();
    private static final double MIN_VALUE = 1.0; //It depends on each type of investment
    private static final double ZERO = 0.0;
    private static final double CREDIT_INCREASE = 0.00010; //same as 0.01%
    private final AgencyType AGENCY;
    private final InvestmentType INVESTMENT_TYPE;
    private final String INV_AC_NUMBER;
    private Person accountOwner;
    private double balance;
    private long passwordHash;

    private double loanCredit;

    private InvestmentAccount (AgencyType ag, InvestmentType invType, Person accountOwner, String ac, String password, double amount){
        this.AGENCY = ag;
        this.INVESTMENT_TYPE = invType;
        this.accountOwner = accountOwner;
        this.INV_AC_NUMBER = ac;
        this.passwordHash = password.hashCode();
        deposit(amount, invType);
    }

    public boolean deposit(double amount, InvestmentType invType){
        if(amount < invType.getMIN_DEPOSIT()){
            return false;
        }
        invType.setBalance(invType.getBalance() + amount);
        Date now = new Date(); //set a date week mm/dd hour aa
        String transaction = String.format("(" + now + ") Deposit in %s: R$ %.2f", invType.getName(), amount);
        statement_list.add(transaction);
        loanCredit += CREDIT_INCREASE;
        return true;

    }
}
