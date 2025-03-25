public class InterestCalculator{
    public static double calculateInterest(double amount, double rate, int time) throws IllegalArgumentException{
        if(amount<0 || rate<0 || time<0){
            throw new IllegalArgumentException("Amount, Rate and Time cannot be less than 0.");
        }
        return (amount*rate*time)/100;
    }
    public static void main(String[] args) {
        try {
            double interest = calculateInterest(10000, 7, 3);
            System.out.println("Interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Program has ended.");
    }
}