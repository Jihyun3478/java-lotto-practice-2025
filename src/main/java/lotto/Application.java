package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        Money money = getMoney();
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();

        Lottos lottos = Lottos.generate(money.getTryCount(), new RandomNumberGenerator());
    }

    private static Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                if (Objects.isNull(input) || input.isBlank()) {
                    throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
                }

                int money = Integer.parseInt(input);
                return new Money(money);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
            }
        }
    }

    private static WinningNumber getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                if (Objects.isNull(input) || input.isBlank()) {
                    throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
                }

                if (input.startsWith(",") || input.endsWith(",")) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호의 입력 형식이 올바르지 않습니다.");
                }

                if (input.contains(",,")) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호의 입력 형식이 올바르지 않습니다.");
                }

                String[] split = input.split(",");
                if (Arrays.stream(split).anyMatch(String::isBlank)) {
                    throw new IllegalArgumentException("[ERROR] 당첨 번호의 입력 형식이 올바르지 않습니다.");
                }
                List<Integer> winningNumber = Arrays.stream(split).map(Integer::parseInt).toList();
                return new WinningNumber(winningNumber);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }
    }

    private static BonusNumber getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                if (Objects.isNull(input) || input.isBlank()) {
                    throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
                }

                int bonusNumber = Integer.parseInt(input);
                return new BonusNumber(bonusNumber);
            } catch (NumberFormatException exception) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
            }
        }
    }
}
