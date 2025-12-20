package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                String input = Console.readLine();

                if (Objects.isNull(input) || input.isBlank()) {
                    throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
                }
                int money = Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
            }
        }
    }
}
