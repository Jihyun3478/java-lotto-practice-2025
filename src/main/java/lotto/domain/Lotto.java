package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public int countHowMatch(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : numbers) {
            for (int winningNumber : winningNumbers) {
                if (number == winningNumber) {
                    matchCount++;
                }
            }
        }
        return matchCount;
    }

    public boolean isMatch(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
