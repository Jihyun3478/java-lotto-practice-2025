package lotto;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getValue() {
        return money;
    }

    public int getTryCount() {
        return money / 1000;
    }

    private void validate(int money) {
        validateMoneyUnit(money);
        validateLowerBound(money);
        validateUpperBound(money);
    }

    private void validateMoneyUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    private void validateLowerBound(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 작거나 같을 수 없습니다.");
        }
    }

    private void validateUpperBound(int money) {
        if (money > 100000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 10만원을 초과할 수 없습니다.");
        }
    }
}
