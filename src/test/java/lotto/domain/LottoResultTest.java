package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LottoResultTest {

    @Test
    void 로또_결과로_생성이_된다() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        rankCounts.put(Rank.FIRST, 0);
        rankCounts.put(Rank.SECOND, 0);
        rankCounts.put(Rank.THIRD, 0);
        rankCounts.put(Rank.FOURTH, 0);
        rankCounts.put(Rank.FIFTH, 1);

        LottoResult result = new LottoResult(rankCounts);

        assertThat(result).isNotNull();
    }

    @Test
    void 각_등수별_당첨_개수를_반환한다() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        rankCounts.put(Rank.FIRST, 1);
        rankCounts.put(Rank.SECOND, 0);
        rankCounts.put(Rank.THIRD, 2);
        rankCounts.put(Rank.FOURTH, 3);
        rankCounts.put(Rank.FIFTH, 5);

        LottoResult result = new LottoResult(rankCounts);

        assertThat(result.getCountByRank(Rank.FIRST)).isEqualTo(1);
        assertThat(result.getCountByRank(Rank.SECOND)).isEqualTo(0);
        assertThat(result.getCountByRank(Rank.THIRD)).isEqualTo(2);
        assertThat(result.getCountByRank(Rank.FOURTH)).isEqualTo(3);
        assertThat(result.getCountByRank(Rank.FIFTH)).isEqualTo(5);
    }

    @Test
    void 등수_정보가_없으면_0을_반환한다() {
        Map<Rank, Integer> rankCounts = new HashMap<>();

        LottoResult result = new LottoResult(rankCounts);

        assertThat(result.getCountByRank(Rank.FIRST)).isEqualTo(0);
        assertThat(result.getCountByRank(Rank.FIFTH)).isEqualTo(0);
    }

    @Test
    void 총_당첨금을_계산한다() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        rankCounts.put(Rank.FIFTH, 2);
        rankCounts.put(Rank.FOURTH, 1);

        LottoResult result = new LottoResult(rankCounts);

        assertThat(result.calculateTotalPrize()).isEqualTo(60_000);
    }

    @Test
    void 당첨_내역이_없으면_총_당첨금이_0이다() {
        Map<Rank, Integer> rankCounts = new HashMap<>();

        LottoResult result = new LottoResult(rankCounts);

        assertThat(result.calculateTotalPrize()).isEqualTo(0);
    }

    @Test
    void 수익률을_계산한다() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        rankCounts.put(Rank.FOURTH, 1);

        LottoResult result = new LottoResult(rankCounts);
        PurchaseAmount purchaseAmount = new PurchaseAmount(10000);

        assertThat(result.calculateProfitRate(purchaseAmount)).isEqualTo(500.0);
    }


    @Test
    void 여러_등수가_섞인_경우_총_당첨금을_계산한다() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        rankCounts.put(Rank.FIRST, 1);
        rankCounts.put(Rank.THIRD, 2);
        rankCounts.put(Rank.FIFTH, 3);

        LottoResult result = new LottoResult(rankCounts);

        assertThat(result.calculateTotalPrize()).isEqualTo(2_003_015_000L);
    }
}
