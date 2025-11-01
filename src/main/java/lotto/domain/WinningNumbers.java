package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateCount(winningNumbers);
        validateRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (1 > winningNumber || winningNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int countMatches(Lotto lotto) {
        return lotto.countMatches(winningNumbers);
    }

    public boolean containNumber(int input) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber.equals(input)) {
                return false;
            }
        }
        return true;
    }

}
