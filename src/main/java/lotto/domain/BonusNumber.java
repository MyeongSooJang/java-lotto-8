package lotto.domain;

import static lotto.constant.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_BONUS_RANGE;
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
            throw new IllegalArgumentException(INVALID_BONUS_RANGE);
        }
    }

    private void validateDuplicate(WinningNumbers winningNumbers, int input) {
        if (winningNumbers.containNumber(input)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER);
        }
    }

    public boolean matches(Lotto lotto) {
        return lotto.containsNumber(bonusNumber);
    }
}
