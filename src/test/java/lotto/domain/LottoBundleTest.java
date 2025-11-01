package lotto.domain;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {

    @Test
    void 구매한_로또들로_생성이된다() {
        Lotto input1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto input2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto input3 = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        LottoBundle lottoBundle = new
    }
}
