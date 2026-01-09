package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {
    private static final String NEW_LINE = "\n";

    public void printLottos(int countByPublishAmount, List<Lotto> lottos) {
        System.out.println(NEW_LINE + countByPublishAmount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String formatLotto = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(formatLotto);
        }
    }
}
