import transfer.TransferCalculator;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        double[] transfers = {
                6057.40095900678, 8836.61529909037, 9764.25444382109, 7497.90805349589,
                4357.2732070142, 720.012565739051, 6172.98568982675, 3955.22909517134,
                6139.59444074629, 6789.37297148259, 3784.11360901859, 8038.21668311446,
                5890.00828639693, 6968.97683238347, 5482.93729511712, 262.009201755319,
                4106.92706255898, 9971.85217862274, 7207.67382465715, 4488.61857827778
        };

        LocalDate[] transferDates = {
                LocalDate.of(1905, 7, 13), LocalDate.of(2023, 10, 15), LocalDate.of(2024, 4, 15), LocalDate.of(2024, 1, 15),
                LocalDate.of(2024, 7, 13), LocalDate.of(2024, 7, 13), LocalDate.of(2023, 3, 15), LocalDate.of(2023, 2, 15),
                LocalDate.of(2024, 1, 15), LocalDate.of(2023, 7, 15), LocalDate.of(2023, 7, 15), LocalDate.of(2022, 12, 15),
                LocalDate.of(2024, 6, 15), LocalDate.of(2024, 7, 13), LocalDate.of(2024, 6, 15), LocalDate.of(2024, 7, 13),
                LocalDate.of(2024, 3, 15), LocalDate.of(2024, 5, 15), LocalDate.of(2024, 7, 13), LocalDate.of(2024, 7, 13)
        };
        TransferCalculator calculator = new TransferCalculator(transfers,transferDates);

        System.out.println("Last 6 months average transfer: " + calculator.calculateLast6MonthsAverageTransfer());

        Map.Entry<Month, Double> maxMonthlyTransfer = calculator.calculateMaxMonthlyTransfer();
        if (maxMonthlyTransfer != null) {
            System.out.println("Highest Month value was in " + maxMonthlyTransfer.getKey()
                    + " and amount was " + maxMonthlyTransfer.getValue());
        } else {
            System.out.println("No valid transfers found.");
        }
    }
}
