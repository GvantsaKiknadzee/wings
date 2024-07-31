package transfer;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public class TransferCalculator {
    
    private final double[] transfers;
    private final LocalDate[] transferDates;

    public TransferCalculator(double[] transfers, LocalDate[] transferDates) {
        this.transfers = transfers;
        this.transferDates = transferDates;
    }
    
    public int calculateLast6MonthsAverageTransfer() {
        LocalDate now = LocalDate.now();
        LocalDate sixMonthsAgo = now.minusMonths(6).minusDays(1);

        double sum = 0;
        int count = 0;

        for (int i = 0; i < transferDates.length; i++) {
            if (transferDates[i].isAfter(sixMonthsAgo) & transferDates[i].isBefore(now.plusDays(1))) {
                sum += transfers[i];
                count++;
            }
        }

        if (count == 0) return 0;

        return (int) Math.round(sum / count);
    }

    public Map.Entry<Month, Double> calculateMaxMonthlyTransfer() {
        Map<Month, Double> monthlyTransfers = new HashMap<>();

        for (int i = 0; i < transferDates.length; i++) {
            if (transfers[i] < 300) continue;

            monthlyTransfers.merge(transferDates[i].getMonth(), transfers[i], Double::sum);
        }

        return monthlyTransfers.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
    }
}
