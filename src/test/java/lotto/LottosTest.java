package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    @DisplayName("구입 금액만큼 로또를 발행한다.")
    void 구입금액만큼_로또를_발행한다() {
        NumberGenerator numberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);

        Lottos lottos = Lottos.generate(5, numberGenerator);

        Assertions.assertThat(lottos.size()).isEqualTo(5);
    }
}
