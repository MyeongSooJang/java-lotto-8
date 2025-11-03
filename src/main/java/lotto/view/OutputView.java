package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;

public class OutputView {

    private static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String STATISTICS_HEADER = "당첨 통계";
    private static final String STATISTICS_DIVIDER = "---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printPurchaseCount(int count) {
        System.out.printf((PURCHASE_COUNT_MESSAGE) + "%n", count);
    }

    public static void printLottos(LottoBundle lottoBundle) {
        List<Lotto> lottos = lottoBundle.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getSortedNumbers();
            System.out.println(numbers);
        }
    }

    public static void printStatistics(LottoResult result) {
        System.out.println(STATISTICS_HEADER);
        System.out.println(STATISTICS_DIVIDER);

        printRankStatistics(Rank.FIFTH, result);
        printRankStatistics(Rank.FOURTH, result);
        printRankStatistics(Rank.THIRD, result);
        printSecondRankStatistics(result);
        printRankStatistics(Rank.FIRST, result);
    }

    private static void printRankStatistics(Rank rank, LottoResult result) {
        int count = result.getCountByRank(rank);
        if (rank == Rank.FIFTH) {
            System.out.println("3개 일치 (5,000원) - " + count + "개");
        }
        if (rank == Rank.FOURTH) {
            System.out.println("4개 일치 (50,000원) - " + count + "개");
        }
        if (rank == Rank.THIRD) {
            System.out.println("5개 일치 (1,500,000원) - " + count + "개");
        }
        if (rank == Rank.FIRST) {
            System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
        }
    }

    private static void printSecondRankStatistics(LottoResult result) {
        int count = result.getCountByRank(Rank.SECOND);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
    }

    public static void printProfitRate(LottoResult result, PurchaseAmount purchaseAmount) {
        double profitRate = result.calculateProfitRate(purchaseAmount);
        System.out.printf((PROFIT_RATE_MESSAGE) + "%n", profitRate);
    }
}
