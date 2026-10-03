package librarymanagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator {

    private static final double FINE_PER_DAY = 5.0;

    public static double calculateFine(LocalDate dueDate,
                                       LocalDate returnDate) {

        if (!returnDate.isAfter(dueDate)) {
            return 0;
        }

        long lateDays = ChronoUnit.DAYS.between(
                dueDate,
                returnDate
        );

        return lateDays * FINE_PER_DAY;
    }

    public static long calculateLateDays(LocalDate dueDate,
                                         LocalDate returnDate) {

        if (!returnDate.isAfter(dueDate)) {
            return 0;
        }

        return ChronoUnit.DAYS.between(
                dueDate,
                returnDate
        );
    }
}