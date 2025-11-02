package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.Test;

public class LottoBundleTest {

    @Test
    void 구매한_로또들로_생성이_된다() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        assertThatCode(() -> new LottoBundle(lottos))
                .doesNotThrowAnyException();
    }

    @Test
    void 구매한_로또_개수를_반환한다() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        LottoBundle lottoBundle = new LottoBundle(lottos);

        assertThat(lottoBundle.getSize()).isEqualTo(3);
    }

    @Test
    void 당첨_번호와_비교하여_로또_결과를_반환한다() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 5개 + 보너스 = 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 10)), // 5개 = 3등
                new Lotto(List.of(1, 2, 3, 20, 21, 22)) // 3개 = 5등
        );
        LottoBundle lottoBundle = new LottoBundle(lottos);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 7));
        BonusNumber bonusNumber = new BonusNumber(winningNumbers, 6);

        LottoResult result = lottoBundle.checkWinning(winningNumbers, bonusNumber);

        assertThat(result).isNotNull();
    }
}
