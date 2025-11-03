package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoBundle {
    private final List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getSize() {
        return lottos.size();
    }

    public LottoResult checkWinning(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Map<Rank, Integer> rankCounts = createRankCounts();

        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(winningNumbers, bonusNumber);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        return new LottoResult(rankCounts);
    }

    private Map<Rank, Integer> createRankCounts() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
