package librarymanagement;

public class FineCalculator {

    private static final double FINE_PER_DAY = 10.0;

    // Calculate fine
    public double calculateFine(long lateDays) {

        if (lateDays <= 0) {
            return 0;
        }

        return lateDays * FINE_PER_DAY;
    }

    // Display fine
    public void displayFine(long lateDays) {

        double fine = calculateFine(lateDays);

        System.out.println("\n===== FINE DETAILS =====");
        System.out.println("Late Days : " + lateDays);
        System.out.println("Fine      : ₹" + fine);
    }
}