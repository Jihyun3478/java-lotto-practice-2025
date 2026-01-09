package lotto.domain;

import java.util.Arrays;

public enum WinningStatistics {
    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int winningAmount;

    WinningStatistics(int matchCount, boolean isBonusMatch, int winningAmount) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.winningAmount = winningAmount;
    }

    public static WinningStatistics from(boolean isBonusMatch, int matchCount) {
        return Arrays.stream(values())
                .filter(statistics -> statistics.isBonusMatch == isBonusMatch && statistics.matchCount == matchCount)
                .findAny()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
