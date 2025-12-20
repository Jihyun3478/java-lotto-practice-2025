package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WinningNumberTest {
    @Nested
    @DisplayName("당첨 번호 생성 테스트")
    class 당첨_번호_생성_테스트 {
        @Test
        @DisplayName("당첨 번호는 6개이다.")
        void 당첨_번호는_6개이다() {
            WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));
            Assertions.assertThat(winningNumber.size()).isEqualTo(6);
        }
    }

    @Nested
    @DisplayName("당첨 번호 생성 예외 테스트")
    class 당첨_번호_생성_예외_테스트 {
        @Test
        @DisplayName("당첨 번호가 6개가 아닌 경우 예외가 발생한다.")
        void 당첨_번호가_6개가_아닌_경우_예외가_발생한다() {
            assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
        }

        @Test
        @DisplayName("당첨 번호가 1과 45 사이의 숫자가 아닌 경우 예외가 발생한다.")
        void 당첨_번호가_1과_45_사이의_숫자가_아닌_경우_예외가_발생한다() {
            assertThatThrownBy(() -> new WinningNumber(List.of(0, 1, 2, 3, 4, 46)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
        }

        @Test
        @DisplayName("당첨 번호가 중복되는 경우 예외가 발생한다.")
        void 당첨_번호가_중복되는_경우_예외가_발생한다() {
            assertThatThrownBy(() -> new WinningNumber(List.of(1, 1, 2, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }
}
