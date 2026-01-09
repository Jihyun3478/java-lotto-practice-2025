package lotto.util;

public class InputParser {
    public static int parseNumber(String input) {
        InputValidator.validateNotBlank(input);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식입니다. 다시 입력해주세요.");
        }
    }
}
