package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    void 당첨번호와_중복되지_않으며_범위가_1부터_45인경우_정상적으로_생성이된다() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;

        WinningNumbers winningNumbers = new WinningNumbers(input);

        assertThatCode(() -> new BonusNumber(winningNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 보너스_번호가_1부터_45까지의_범위를_벗어나면_예외를_발생시킨다() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 46;

        WinningNumbers winningNumbers = new WinningNumbers(input);

        assertThatThrownBy(() -> new BonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 당첨_번호와_보너스_번호가_중복이면_예외를_발생시킨다() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        WinningNumbers winningNumbers = new WinningNumbers(input);

        assertThatThrownBy(() -> new BonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
