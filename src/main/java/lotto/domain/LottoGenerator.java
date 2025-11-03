package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public LottoBundle generate(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.calculateLottoCount();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateSingleLotto());
        }

        return new LottoBundle(lottos);
    }

    private Lotto generateSingleLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_MIN,
                LOTTO_NUMBER_MAX,
                LOTTO_NUMBER_COUNT
        );
        return new Lotto(numbers);
    }
}
