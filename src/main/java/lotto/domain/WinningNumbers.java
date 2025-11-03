package lotto.domain;

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
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (LOTTO_NUMBER_MIN > winningNumber || winningNumber > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
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
