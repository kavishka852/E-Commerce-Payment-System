public class PaymentTest {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Payment System ===\n");

        CashOnDelivery cod = new CashOnDelivery(5000.00, "LKR", "123 Main St, Colombo");

        BankTransfer bankTransfer = new BankTransfer(5000.00, "LKR",
                "Bank of Ceylon", "1234567890", "REF-2025-001");

        CreditCardPayment creditCard = new CreditCardPayment(5000.00, "LKR",
                "4111-1111-1111-1111", "Kamal", "12/27", 100000.00);

        DebitCardPayment debitCard = new DebitCardPayment(5000.00, "LKR",
                "5500-0000-0000-0004", "Kamal", "06/26", 50000.00);

        System.out.println("--- Cash on Delivery ---");
        cod.processPayment();
        cod.generateReceipt();
        System.out.println();

        System.out.println("--- Bank Transfer ---");
        bankTransfer.processPayment();
        bankTransfer.generateReceipt();
        System.out.println();

        System.out.println("--- Credit Card ---");
        creditCard.validateCard();
        creditCard.processPayment();
        creditCard.applyInterest();
        creditCard.generateReceipt();
        System.out.println();

        System.out.println("--- Debit Card ---");
        debitCard.validateCard();
        debitCard.checkSufficientBalance();
        debitCard.processPayment();
        debitCard.generateReceipt();
        System.out.println();

        System.out.println("=== Demo ===");
        java.util.List<Payment> payments = new java.util.ArrayList<>();
        payments.add(cod);
        payments.add(bankTransfer);
        payments.add(creditCard);
        payments.add(debitCard);

        System.out.println("\nProcessing all payments:");
        for (Payment payment : payments) {
            System.out.println("\nProcessing " + payment.getClass().getSimpleName() + ":");
            payment.processPayment();
        }
    }
}