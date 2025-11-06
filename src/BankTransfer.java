class BankTransfer extends Payment {
    private String bankName;
    private String accountNumber;
    private String referenceCode;

    public BankTransfer(double amount, String currency, String bankName,
                        String accountNumber, String referenceCode) {
        super(amount, currency);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.referenceCode = referenceCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    @Override
    public void processPayment() {
        System.out.println("Initiating bank transfer to " + bankName +
                " using account " + accountNumber +
                " with reference " + referenceCode);
        markAsCompleted();
    }

    @Override
    public boolean validate() {
        if (bankName == null || bankName.trim().isEmpty()) {
            System.out.println("Validation failed: Bank name is required");
            return false;
        }
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            System.out.println("Validation failed: Account number is required");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Validation failed: Amount must be positive");
            return false;
        }
        System.out.println("Bank transfer validation passed");
        return true;
    }
}