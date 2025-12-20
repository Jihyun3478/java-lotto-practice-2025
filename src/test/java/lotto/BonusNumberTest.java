package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @Nested
    @DisplayName("보너스 번호 생성 예외 테스트")
    class 보너스_번호_생성_예외_테스트 {
        @ParameterizedTest
        @ValueSource(ints = {0, 46})
        @DisplayName("보너스 번호가 1과 45 사이의 숫자가 아닌 경우 예외가 발생한다.")
        void 보너스_번호가_1과_45_사이의_숫자가_아닌_경우_예외가_발생한다(int bonusNumber) {
            assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 보너스 번호는 1과 45 사이의 숫자여야 합니다.");
        }
    }
}
