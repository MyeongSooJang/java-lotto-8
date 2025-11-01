package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {

    @Test
    void 입력한_금액으로_생성이_된다() {
        int input = 10000;

        assertThatCode(() -> new PurchaseAmount(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 천원_단위가_아닌_값을_입력하는_경우_예외를_발생시킨다() {
        int input = 10100;

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수를_입력하는_경우_예외를_발생시킨다() {
        int input = -10000;

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매한_로또_개수를_반환한다() {
        int input = 10000;

        PurchaseAmount purchaseAmount = new PurchaseAmount(input);

        assertThat(purchaseAmount.calculateLottoCount()).isEqualTo(10);
    }
}
