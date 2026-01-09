package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.service.NumberGenerator;

public class LottoManager {
    private final NumberGenerator numberGenerator;
    private Map<WinningStatistics, Integer> winningResult;

    public LottoManager(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.winningResult = setUp();
    }

    private Map<WinningStatistics, Integer> setUp() {
        this.winningResult = new EnumMap<>(WinningStatistics.class);
        for (WinningStatistics winningStatistic : WinningStatistics.values()) {
            this.winningResult.put(winningStatistic, 0);
        }
        return this.winningResult;
    }

    public List<Lotto> publishLotto(int countByPurchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < countByPurchaseAmount; count++) {
            List<Integer> randomNumbers = numberGenerator.generate();
            List<Integer> sortNumbers = sort(randomNumbers);
            lottos.add(new Lotto(sortNumbers));
        }
        return lottos;
    }

    public Map<WinningStatistics, Integer> getWinningResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            boolean isBonusMatch = lotto.isMatch(bonusNumber);
            int countHowMatch = lotto.countHowMatch(winningNumbers);

            WinningStatistics winningStatistics = WinningStatistics.from(isBonusMatch, countHowMatch);
            winningResult.put(winningStatistics, winningResult.getOrDefault(winningStatistics, 0) + 1);
        }
        return winningResult;
    }

    public double getProfitRate(int purchaseAmount) {
        int totalWinningAmount = 0;
        for (Entry<WinningStatistics, Integer> result : winningResult.entrySet()) {
            totalWinningAmount += result.getKey().getWinningAmount() * result.getValue();
        }
        return calculateProfitRate(totalWinningAmount, purchaseAmount);
    }

    private List<Integer> sort(List<Integer> lottos) {
        return lottos.stream()
                .sorted()
                .toList();
    }

    private double calculateProfitRate(int winningAmount, int purchaseAmount) {
        double rate = ((double) winningAmount / purchaseAmount) * 100;
        return Math.round(rate * 10) / 10.0;
    }
}
