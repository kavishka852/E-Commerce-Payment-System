class CreditCardPayment extends CardPayment {
    private double creditLimit;

    public CreditCardPayment(double amount, String currency, String cardNumber,
                             String cardHolderName, String expiryDate, double creditLimit) {
        super(amount, currency, cardNumber, cardHolderName, expiryDate);
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void processPayment() {
        System.out.println("Charging credit card with limit " + creditLimit +
                " for amount " + amount);
    }

    public void applyInterest() {
        System.out.println("Applying interest if payment is not settled by due date");
    }
}