
public class CreditCardValidator {
    public static boolean isValidVisa(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$");
    }

    public static boolean isValidMasterCard(String cardNumber) {
        return cardNumber.matches("^5\\d{15}$");
    }

    public static void main(String[] args) {
        String[] testCards = {
            "4123456789012345",  // Visa ✅
            "5123456789012345",  // MasterCard ✅
            "6123456789012345",  // Invalid ❌
            "41234567890123",    // Invalid ❌ (too short)
            "51234567890123456"  // Invalid ❌ (too long)
        };

        for (String card : testCards) {
            if (isValidVisa(card)) {
                System.out.printf("Card: %s → Valid Visa ✅%n", card);
            } else if (isValidMasterCard(card)) {
                System.out.printf("Card: %s → Valid MasterCard ✅%n", card);
            } else {
                System.out.printf("Card: %s → Invalid ❌%n", card);
            }
        }
    }
}
