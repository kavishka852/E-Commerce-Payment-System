class CashOnDelivery extends Payment {
    private String deliveryAddress;

    public CashOnDelivery(double amount, String currency, String deliveryAddress) {
        super(amount, currency);
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public void processPayment() {
        System.out.println("Cash will be collected at delivery address: " + deliveryAddress);
    }

    @Override
    public boolean validate() {
        if (deliveryAddress == null || deliveryAddress.trim().isEmpty()) {
            System.out.println("Validation failed: Delivery address is required");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Validation failed: Amount must be positive");
            return false;
        }
        System.out.println("COD validation passed");
        return true;
    }
}