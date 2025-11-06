public class PaymentTest {
    public static void main(String[] args) {
        System.out.println("=== E-Commerce Payment System with Abstraction & Interfaces ===\n");

        // Create payment instances
        CashOnDelivery cod = new CashOnDelivery(5000.00, "LKR", "123 Main St, Colombo");
        BankTransfer bankTransfer = new BankTransfer(5000.00, "LKR",
                "Bank of Ceylon", "1234567890", "REF-2025-001");
        CreditCardPayment creditCard = new CreditCardPayment(5000.00, "LKR",
                "4111-1111-1111-1111", "Kamal", "12/27", 100000.00);
        DebitCardPayment debitCard = new DebitCardPayment(5000.00, "LKR",
                "5500-0000-0000-0004", "Kamal", "06/26", 50000.00);

        // Test Cash on Delivery
        System.out.println("--- Cash on Delivery ---");
        cod.validate();
        cod.processPayment();
        cod.generateReceipt();
        System.out.println();

        // Test Bank Transfer
        System.out.println("--- Bank Transfer ---");
        bankTransfer.validate();
        bankTransfer.processPayment();
        bankTransfer.generateReceipt();
        System.out.println();

        // Test Credit Card with Discount
        System.out.println("--- Credit Card ---");
        creditCard.validate();
        creditCard.validateCard();
        creditCard.applyDiscount(10.0); // Apply 10% discount
        creditCard.processPayment();
        creditCard.applyInterest();
        creditCard.generateReceipt();
        System.out.println("Final amount after discount: " + creditCard.finalAmount());
        System.out.println();

        // Test Debit Card with Discount
        System.out.println("--- Debit Card ---");
        debitCard.validate();
        debitCard.validateCard();
        debitCard.applyDiscount(5.0); // Apply 5% discount
        debitCard.checkSufficientBalance();
        debitCard.processPayment();
        debitCard.generateReceipt();
        System.out.println("Final amount after discount: " + debitCard.finalAmount());
        System.out.println();

        // Payable interface
        java.util.List<Payable> payables = new java.util.ArrayList<>();
        payables.add(cod);
        payables.add(bankTransfer);
        payables.add(creditCard);
        payables.add(debitCard);

        System.out.println("\nValidating all Payable objects:");
        for (Payable payable : payables) {
            System.out.println("Reference: " + payable.getReference() +
                    " - Valid: " + payable.validate());
        }

        // Payment abstract class
        java.util.List<Payment> payments = new java.util.ArrayList<>();
        payments.add(cod);
        payments.add(bankTransfer);
        payments.add(creditCard);
        payments.add(debitCard);

        System.out.println("\nProcessing all payments:");
        for (Payment payment : payments) {
            System.out.println("\n" + payment.getClass().getSimpleName() + ":");
            payment.processPayment();
        }

        //Discount interface
        System.out.println("\nApplying discounts to card payments:");

        CreditCardPayment creditCard2 = new CreditCardPayment(10000.00, "LKR",
                "4111-2222-3333-4444", "Nimal", "08/28", 150000.00);
        System.out.println("\nCredit Card - Original: " + creditCard2.getAmount());
        creditCard2.applyDiscount(15.0);
        System.out.println("After discount: " + creditCard2.finalAmount());

        DebitCardPayment debitCard2 = new DebitCardPayment(8000.00, "LKR",
                "5500-1111-2222-3333", "Saman", "11/27", 60000.00);
        System.out.println("\nDebit Card - Original: " + debitCard2.getAmount());
        debitCard2.applyDiscount(7.5);
        System.out.println("After discount: " + debitCard2.finalAmount());

        // multiple inheritance via Discount interface
        java.util.List<Discount> discountablePayments = new java.util.ArrayList<>();
        discountablePayments.add(creditCard);
        discountablePayments.add(debitCard);

        System.out.println("\nApplying 20% discount to all discountable payments:");
        for (Discount discount : discountablePayments) {
            discount.applyDiscount(20.0);
            System.out.println("Final amount: " + discount.finalAmount());
        }
    }
}