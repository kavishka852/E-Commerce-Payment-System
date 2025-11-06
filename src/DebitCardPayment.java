class DebitCardPayment extends CardPayment implements Discount {
    private double availableBalance;
    private double discountedAmount;

    public DebitCardPayment(double amount, String currency, String cardNumber,
                            String cardHolderName, String expiryDate, double availableBalance) {
        super(amount, currency, cardNumber, cardHolderName, expiryDate);
        this.availableBalance = availableBalance;
        this.discountedAmount = amount;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
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
        System.out.println("Debiting from account balance " + availableBalance +
                " for amount " + finalAmount());
    }

    public void checkSufficientBalance() {
        if (availableBalance >= finalAmount()) {
            System.out.println("Sufficient balance available");
        } else {
            System.out.println("Insufficient balance");
        }
    }
}