package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_MAX;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_MIN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateMin(numbers);
        validateMax(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateMin(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_NUMBER_MIN) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 이어야 합니다.");
            }
        }
    }

    private void validateMax(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 45미만 이어야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public int countMatches(List<Integer> input) {
        return (int) numbers.stream()
                .filter(input::contains)
                .count();
    }

    public boolean containsNumber(int input) {
        for (Integer number : numbers) {
            if (number == input) {
                return true;
            }
        }
        return false;
    }

    public Rank match(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = winningNumbers.countMatches(this);
        boolean bonusMatch = bonusNumber.matches(this);
        return Rank.from(matchCount, bonusMatch);
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        return sorted;
    }
}
