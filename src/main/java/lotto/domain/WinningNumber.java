package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumber;
    private int bonusNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validate(winningNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = 0;
    }

    public void addBonusNumber(int bonusNumber) {
        validateDuplicate(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumber) {
        validateDuplicate(winningNumber);
        validateSize(winningNumber);
        validateRange(winningNumber);
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

    private void validateRange(List<Integer> winningNumber) {
        boolean isInRange = winningNumber.stream()
                .allMatch(number -> number >= 1 && number <= 45);

        if (!isInRange) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다. 다시 입력해주세요.");
        }
    }

    private void validateDuplicate(int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다. 다시 입력해주세요.");
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다. 다시 입력해주세요.");
        }
    }
}
