package transfer;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class TransferCalculator {
    private final double[] transfers = {
            6057.40095900678, 8836.61529909037, 9764.25444382109, 7497.90805349589,
            4357.2732070142, 720.012565739051, 6172.98568982675, 3955.22909517134,
            6139.59444074629, 6789.37297148259, 3784.11360901859, 8038.21668311446,
            5890.00828639693, 6968.97683238347, 5482.93729511712, 262.009201755319,
            4106.92706255898, 9971.85217862274, 7207.67382465715, 4488.61857827778
    };

    private final LocalDate[] transferDates = {
            LocalDate.of(1905, 7, 13), LocalDate.of(2023, 10, 15), LocalDate.of(2024, 4, 15), LocalDate.of(2024, 1, 15),
            LocalDate.of(2024, 7, 13), LocalDate.of(2024, 7, 13), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 2, 15),
            LocalDate.of(2024, 1, 15), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 7, 15), LocalDate.of(2022, 12, 15),
            LocalDate.of(2024, 6, 15), LocalDate.of(2024, 7, 13), LocalDate.of(2024, 6, 15), LocalDate.of(2024, 7, 13),
            LocalDate.of(2024, 3, 15), LocalDate.of(2024, 5, 15), LocalDate.of(2024, 7, 13), LocalDate.of(2024, 7, 13)
    };

    public int calculateLast6MonthsAverageTransfer() {
        LocalDate now = LocalDate.now();
        LocalDate sixMonthsAgo = now.minus(6, ChronoUnit.MONTHS);

        double sum = 0;
        int count = 0;

        for (int i = 0; i < transferDates.length; i++) {
            if (transferDates[i].isAfter(sixMonthsAgo.minusDays(1)) & transferDates[i].isBefore(now.plusDays(1))) {
                sum += transfers[i];
                count++;
            }
        }

        if (count == 0) return 0;

        return (int) Math.round(sum / count);
    }

    public Map<Month, Double> calculateMaxMonthlyTransfer() {
        Map<Month, Double> highestMonthlyTransfers = new HashMap<>();

        for (int i = 0; i < transferDates.length; i++) {
            if (transfers[i] < 300) continue;

            Month month = transferDates[i].getMonth();
            highestMonthlyTransfers.merge(month, transfers[i], Math::max);
        }

        return highestMonthlyTransfers;
    }

}
