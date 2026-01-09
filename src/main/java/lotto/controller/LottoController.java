package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;
import lotto.service.NumberGenerator;
import lotto.service.RandomNumberGenerator;
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
        int countByPurchaseAmount = purchaseAmount.countByPurchaseAmount();

        List<Lotto> lottos = getLottos(countByPurchaseAmount);

        WinningNumber winningNumber = getWinningNumber();
    }

    private List<Lotto> getLottos(int countByPurchaseAmount) {
        LottoManager lottoManager = new LottoManager(new RandomNumberGenerator());
        List<Lotto> lottos = lottoManager.publishLotto(countByPurchaseAmount);

        outputView.printLottos(countByPurchaseAmount, lottos);
        return lottos;
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
