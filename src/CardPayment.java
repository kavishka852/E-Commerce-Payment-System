abstract class CardPayment extends Payment {
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
    public boolean validate() {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            System.out.println("Card validation failed: Card number is required");
            return false;
        }
        if (cardHolderName == null || cardHolderName.trim().isEmpty()) {
            System.out.println("Card validation failed: Card holder name is required");
            return false;
        }
        if (expiryDate == null || expiryDate.trim().isEmpty()) {
            System.out.println("Card validation failed: Expiry date is required");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Card validation failed: Amount must be positive");
            return false;
        }
        System.out.println("Card validation passed");
        return true;
    }

    public void validateCard() {
        System.out.println("Validating card number format...");
    }
}