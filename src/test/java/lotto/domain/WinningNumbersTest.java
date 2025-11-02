package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 당첨번호는_6개의_숫자들로_만들어진다() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> new WinningNumbers(input))
                .doesNotThrowAnyException();
    }

    @Test
    void 당첨번호의_숫자갯수가_적은_경우_예외를_발생한다() {
        List<Integer> input = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호의_숫자갯수가_많은_경우_예외를_발생한다() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> new WinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호가_번호의_숫자가_1부터_45범위를_벗어난_경우_예외를_발생한다() {
        List<Integer> input1 = List.of(1, 2, 3, 4, 5, 46);
        List<Integer> input2 = List.of(0, 2, 3, 4, 5, 45);

        assertThatThrownBy(() -> new WinningNumbers(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new WinningNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또를_넣어주면_일치하는_숫자_갯수를_알려준다() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

        WinningNumbers winningNumbers = new WinningNumbers(input);

        assertThat(winningNumbers.countMatches(new Lotto(List.of(1,2,3,4,5,6)))).isEqualTo(6);
        assertThat(winningNumbers.countMatches(new Lotto(List.of(1,2,3,14,15,16)))).isEqualTo(3);
        assertThat(winningNumbers.countMatches(new Lotto(List.of(11,22,33,34,35,36)))).isEqualTo(0);
    }
}

