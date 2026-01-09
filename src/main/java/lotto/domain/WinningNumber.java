package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validate(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void validate(List<Integer> winningNumber) {
        validateDuplicate(winningNumber);
        validateSize(winningNumber);
    }

    private void validateDuplicate(List<Integer> winningNumber) {
        if (winningNumber.size() != new HashSet<>(winningNumber).size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다. 다시 입력해주세요.");
        }
    }

    private void validateSize(List<Integer> winningNumber) {
        if (winningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개까지 입력 가능합니다. 다시 입력해주세요.");
        }
    }
}
