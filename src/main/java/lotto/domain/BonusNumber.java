package lotto.domain;

public class BonusNumber {
    private static final int BONUS_NUMBER_MIN = 1;
    private static final int BONUS_NUMBER_MAX = 45;

    private final int bonusNumber;

    public BonusNumber(WinningNumbers winningNumbers, int input) {
        validateRange(input);
        validateDuplicate(winningNumbers, input);
        this.bonusNumber = input;
    }

    private void validateRange(int input) {
        if (input < BONUS_NUMBER_MIN || input > BONUS_NUMBER_MAX) {
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
