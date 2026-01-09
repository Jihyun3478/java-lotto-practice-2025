package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class InputParser {
    public static int parseNumber(String input) {
        InputValidator.validateNotBlank(input);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식입니다. 다시 입력해주세요.");
        }
    }

    public static List<Integer> parseWinningNumber(String input) {
        InputValidator.validateNotBlank(input);

        try {
            String[] splitInput = input.split(",");
            return Arrays.stream(splitInput)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (PatternSyntaxException | NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식입니다. 다시 입력해주세요.");
        }
    }
}
