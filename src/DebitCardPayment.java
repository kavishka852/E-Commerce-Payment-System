class DebitCardPayment extends CardPayment {
    private double availableBalance;

    public DebitCardPayment(double amount, String currency, String cardNumber,
                            String cardHolderName, String expiryDate, double availableBalance) {
        super(amount, currency, cardNumber, cardHolderName, expiryDate);
        this.availableBalance = availableBalance;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Override
    public void processPayment() {
        System.out.println("Debiting from account balance " + availableBalance +
                " for amount " + amount);
    }

    public void checkSufficientBalance() {
        System.out.println("Checking if balance covers amount");
    }
}