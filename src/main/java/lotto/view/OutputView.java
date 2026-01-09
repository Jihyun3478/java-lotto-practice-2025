package lotto.view;

public class OutputView {
    private static final String NEW_LINE = "\n";

    public void start() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void prompt() {
        System.out.println("");
    }

    public void finish() {
        System.out.print("");
    }

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
