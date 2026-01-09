package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;
import lotto.util.InputParser;
import lotto.util.RetryHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        WinningNumber winningNumber = getWinningNumber();
    }

    private PurchaseAmount inputPurchaseAmount() {
        return RetryHandler.retryUntilSuccessWithReturn(() -> {
            String input = inputView.readPurchaseAmount();
            return new PurchaseAmount(InputParser.parseNumber(input));
        });
    }

    private WinningNumber getWinningNumber() {
        WinningNumber winningNumber = inputWinningNumber();

        int bonusNumber = inputBonusNumber();
        winningNumber.addBonusNumber(bonusNumber);

        return winningNumber;
    }

    private WinningNumber inputWinningNumber() {
        return RetryHandler.retryUntilSuccessWithReturn(() -> {
            String input = inputView.readWinningNumber();
            return new WinningNumber(InputParser.parseWinningNumber(input));
        });
    }

    private int inputBonusNumber() {
        return RetryHandler.retryUntilSuccessWithReturn(() -> {
            String input = inputView.readBonusNumber();
            return InputParser.parseNumber(input);
        });
    }
}
