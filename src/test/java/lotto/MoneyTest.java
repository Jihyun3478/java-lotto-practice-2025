package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    @Nested
    @DisplayName("구입금액 생성 테스트")
    class 구입금액_생성_테스트 {
        @Test
        @DisplayName("구입 금액은 1,000원 단위이다.")
        void 구입_금액을_생성한다() {
            Money money = new Money(5000);
            Assertions.assertThat(money.getValue()).isEqualTo(5000);
        }
    }

    @Nested
    @DisplayName("구입금액 생성 예외 테스트")
    class 구입금액_생성_예외_테스트 {
        @ParameterizedTest
        @ValueSource(ints = {1500, 3250, 5600})
        @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
        void 구입_금액이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다(int money) {
            assertThatThrownBy(() -> new Money(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }

        @ParameterizedTest
        @ValueSource(ints = {-5000, -1000, 0})
        @DisplayName("구입 금액이 0보다 작거나 같을 경우 예외가 발생한다.")
        void 구입_금액이_0보다_작거나_같을_경우_예외가_발생한다(int money) {
            assertThatThrownBy(() -> new Money(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 구입 금액은 0보다 작거나 같을 수 없습니다.");
        }

        @ParameterizedTest
        @ValueSource(ints = {500000, 1000000, 1000000000})
        @DisplayName("구입 금액이 10만원을 초과할 경우 예외가 발생한다.")
        void 구입_금액이_10만원을_초과할_경우_예외가_발생한다(int money) {
            assertThatThrownBy(() -> new Money(money))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 구입 금액은 10만원을 초과할 수 없습니다.");
        }
    }
}
