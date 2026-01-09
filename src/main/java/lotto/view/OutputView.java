package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinningStatistics;

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

    public void printWinningStatistics(Map<WinningStatistics, Integer> winningResult, double profitRate) {
        System.out.println(NEW_LINE + "당첨 통계");
        System.out.println("---");
        for (WinningStatistics winningStatistic : WinningStatistics.values()) {
            if (winningStatistic != WinningStatistics.NONE) {
                if (winningStatistic != WinningStatistics.SECOND) {
                    System.out.printf("%d개 일치 (%,d원) - %d개%n",
                            winningStatistic.getMatchCount(),
                            winningStatistic.getWinningAmount(),
                            winningResult.get(winningStatistic));
                }
                if (winningStatistic == WinningStatistics.SECOND) {
                    System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n",
                            winningStatistic.getMatchCount(),
                            winningStatistic.getWinningAmount(),
                            winningResult.get(winningStatistic));
                }
            }
        }
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
