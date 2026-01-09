package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController(
                    new InputView(),
                    new OutputView()
            );
            lottoController.start();
        } finally {
            Console.close();
        }
    }
}
