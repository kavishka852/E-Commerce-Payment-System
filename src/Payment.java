class Payment {
    protected double amount;
    protected String currency;
    protected String status;

    public Payment(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
        this.status = "PENDING";
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void processPayment() {
        System.out.println("Processing generic payment...");
    }

    public void generateReceipt() {
        System.out.println("Receipt for amount " + amount + " " + currency);
    }

    public void markAsCompleted() {
        this.status = "COMPLETED";
        System.out.println("Payment marked as COMPLETED");
    }
}