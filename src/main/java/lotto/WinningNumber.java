package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validate(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void validate(List<Integer> winningNumber) {
        validateSize(winningNumber);
        validateRange(winningNumber);
        validateDuplicate(winningNumber);
    }

    private void validateSize(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> winningNumber) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(winningNumber);
        if (winningNumber.size() != notDuplicateNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    public int size() {
        return winningNumber.size();
    }
}
