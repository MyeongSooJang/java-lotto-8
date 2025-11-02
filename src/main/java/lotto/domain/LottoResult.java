package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts;

    public LottoResult(Map<Rank, Integer> rankCounts) {
        this.rankCounts = new HashMap<>(rankCounts);
    }

    public int getCountByRank(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public long calculateTotalPrize() {
        long total = 0;
        for (Rank rank : Rank.values()) {
            int count = rankCounts.getOrDefault(rank, 0);
            total += rank.calculateTotalPrize(count);
        }
        return total;
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / purchaseAmount.getAmount() * 100;
    }
}
