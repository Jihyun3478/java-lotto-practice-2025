package lotto.domain;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int countByPurchaseAmount() {
        return this.purchaseAmount / 1000;
    }

    private void validate(int purchaseAmount) {
        validateDivide(purchaseAmount);
        validateMinimum(purchaseAmount);
        validateMaximum(purchaseAmount);
    }

    private void validateDivide(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력 가능합니다. 다시 입력해주세요.");
        }
    }

    private void validateMinimum(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다. 다시 입력해주세요.");
        }
    }

    private void validateMaximum(int purchaseAmount) {
        if (purchaseAmount > 100000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 100,000원 이하여야 합니다. 다시 입력해주세요.");
        }
    }
}
