public enum InvestmentType {

    TESOURO_DIRETO("Tesouro Direto", 30.0),
    SELIC("SELIC",30.0),
    CDI("CDI",1.0),
    POUPANÇA("Poupança",1.0);

    final double MIN_DEPOSIT;
    double balance;
    final String name;
    InvestmentType(String name, double min){
        this.name = name;
        this.MIN_DEPOSIT = min;
        this.balance = 0.0;
    }
    public double getMIN_DEPOSIT() {
        return MIN_DEPOSIT;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
