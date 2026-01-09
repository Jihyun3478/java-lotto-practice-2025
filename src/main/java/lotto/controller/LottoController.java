package lotto.controller;

import lotto.domain.PurchaseAmount;
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
        PurchaseAmount purchaseAmount = getPurchaseAmount();
    }

    private PurchaseAmount getPurchaseAmount() {
        return RetryHandler.retryUntilSuccessWithReturn(() -> {
            String input = inputView.readPurchaseAmount();
            return new PurchaseAmount(InputParser.parseNumber(input));
        });
    }
}
