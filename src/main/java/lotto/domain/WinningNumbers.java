package lotto.domain;

import static lotto.constant.ErrorMessage.DUPLICATE_LOTTO_NUMBER;
import static lotto.constant.ErrorMessage.INVALID_WINNING_RANGE;
import static lotto.constant.ErrorMessage.INVALID_WINNING_SIZE;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_MAX;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_MIN;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateCount(winningNumbers);
        validateRange(winningNumbers);
        validateDuplicate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_WINNING_SIZE);
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (LOTTO_NUMBER_MIN > winningNumber || winningNumber > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(INVALID_WINNING_RANGE);
            }
        }
    }
    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    public int countMatches(Lotto lotto) {
        return lotto.countMatches(winningNumbers);
    }

    public boolean containNumber(int input) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber.equals(input)) {
                return true;
            }
        }
        return false;
    }

}
