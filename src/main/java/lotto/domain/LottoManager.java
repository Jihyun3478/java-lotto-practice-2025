package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.service.NumberGenerator;

public class LottoManager {
    private final NumberGenerator numberGenerator;

    public LottoManager(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> publishLotto(int countByPurchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < countByPurchaseAmount; count++) {
            List<Integer> randomNumbers = numberGenerator.generate();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }
}
