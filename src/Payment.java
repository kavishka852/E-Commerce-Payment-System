abstract class Payment implements Payable {
    protected double amount;
    protected String currency;
    protected String status;
    protected String referenceId;

    public Payment(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
        this.status = "PENDING";
        this.referenceId = "TXN-" + (int)(Math.random() * 10000);
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

    @Override
    public String getReference() {
        return referenceId;
    }

    public abstract void processPayment();

    public void generateReceipt() {
        System.out.println("Receipt for amount " + amount + " " + currency);
        System.out.println("Reference: " + referenceId);
        System.out.println("Status: " + status);
    }

    public void markAsCompleted() {
        this.status = "COMPLETED";
        System.out.println("Payment marked as COMPLETED");
    }
}