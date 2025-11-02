package lotto.domain;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(WinningNumbers winningNumbers, int input) {
        validateRange(input);
        validateDuplicate(winningNumbers, input);
        this.bonusNumber = input;
    }

    private void validateRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(WinningNumbers winningNumbers, int input) {
        if (winningNumbers.containNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean matches(Lotto lotto) {
        return lotto.containsNumber(bonusNumber);
    }
}
