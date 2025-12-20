package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Nested
    @DisplayName("로또 생성 테스트")
    class 로또_생성_테스트 {
        @Test
        @DisplayName("하나의 로또는 6개의 숫자를 가지고 있다.")
        void 하나의_로또는_6개의_숫자를_가지고_있다() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            Assertions.assertThat(lotto.size()).isEqualTo(6);
        }
    }

    @Nested
    @DisplayName("로또 생성 예외 테스트")
    class 로또_생성_예외_테스트 {
        @Test
        @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        @Test
        @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }
}
