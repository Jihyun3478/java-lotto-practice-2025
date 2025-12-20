package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generate(int tryCount, NumberGenerator numberGenerator) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            lottos.add(new Lotto(numberGenerator.generate()));
        }
        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }
}
