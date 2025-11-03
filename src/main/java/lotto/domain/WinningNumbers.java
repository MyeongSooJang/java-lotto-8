package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateCount(winningNumbers);
        validateRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (1 > winningNumber || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
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
