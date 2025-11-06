class CreditCardPayment extends CardPayment implements Discount {
    private double creditLimit;
    private double discountedAmount;

    public CreditCardPayment(double amount, String currency, String cardNumber,
                             String cardHolderName, String expiryDate, double creditLimit) {
        super(amount, currency, cardNumber, cardHolderName, expiryDate);
        this.creditLimit = creditLimit;
        this.discountedAmount = amount;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public double applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid discount percentage");
            return discountedAmount;
        }
        discountedAmount = amount * (1 - percent / 100);
        System.out.println("Discount of " + percent + "% applied. New amount: " + discountedAmount);
        return discountedAmount;
    }

    @Override
    public double finalAmount() {
        return discountedAmount;
    }

    @Override
    public void processPayment() {
        System.out.println("Charging credit card with limit " + creditLimit +
                " for amount " + finalAmount());
    }

    public void applyInterest() {
        System.out.println("Applying interest if payment is not settled by due date");
    }
}