package lotto.domain;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int input) {
        validateRange(input);
        this.bonusNumber = input;
    }

    private void validateRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException();
        }
    }


}
