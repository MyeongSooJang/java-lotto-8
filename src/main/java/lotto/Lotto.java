package lotto;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateMin(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 이어야 합니다.");
            }
        }
    }

    private void validateMax(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45) {
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
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < input.size(); j++) {
                if (numbers.get(i).equals(input.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean containsNumber(int input) {
        for (Integer number : numbers) {
            if (number == input) {
                return true;
            }
        }
        return false;
    }

}
