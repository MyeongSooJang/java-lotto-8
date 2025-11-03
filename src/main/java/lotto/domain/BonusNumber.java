package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_MAX;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_MIN;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(WinningNumbers winningNumbers, int input) {
        validateRange(input);
        validateDuplicate(winningNumbers, input);
        this.bonusNumber = input;
    }

    private void validateRange(int input) {
        if (input < LOTTO_NUMBER_MIN || input > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicate(WinningNumbers winningNumbers, int input) {
        if (winningNumbers.containNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean matches(Lotto lotto) {
        return lotto.containsNumber(bonusNumber);
    }
}
