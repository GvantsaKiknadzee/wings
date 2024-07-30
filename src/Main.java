import transfer.TransferCalculator;

import java.time.Month;
import java.util.Map;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {
        TransferCalculator calculator = new TransferCalculator();
        System.out.println("Last 6 months average transfer: " + calculator.calculateLast6MonthsAverageTransfer());

        Map<Month, Double> maxMonthlyTransfers = calculator.calculateMaxMonthlyTransfer();
        printMaxMonthlyTransfers(maxMonthlyTransfers);

        findAndPrintMonthWithMaxAmount(maxMonthlyTransfers);
    }

    private static void printMaxMonthlyTransfers(Map<Month, Double> maxMonthlyTransfers) {
        System.out.println("Month        Maximum Transfer Amount");
        System.out.println("-------------------------------------");
        for (Map.Entry<Month, Double> entry : maxMonthlyTransfers.entrySet()) {
            System.out.printf("%-12s : %10.2f%n", entry.getKey(), entry.getValue());
        }
    }

    private static void findAndPrintMonthWithMaxAmount(Map<Month, Double> maxMonthlyTransfers) {
        Optional<Map.Entry<Month, Double>> monthWithMaxAmountOptional = maxMonthlyTransfers.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        monthWithMaxAmountOptional.ifPresent(monthWithMaxAmount ->
                System.out.println("Month with highest amount is " + monthWithMaxAmount.getKey() +
                        " with amount of " + monthWithMaxAmount.getValue())
        );
    }
}