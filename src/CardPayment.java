class CardPayment extends Payment {
    protected String cardNumber;
    protected String cardHolderName;
    protected String expiryDate;

    public CardPayment(double amount, String currency, String cardNumber,
                       String cardHolderName, String expiryDate) {
        super(amount, currency);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment() {
        System.out.println("Authorizing card payment for " + cardHolderName + " ...");
    }

    public void validateCard() {
        System.out.println("Validating card number format...");
    }
}