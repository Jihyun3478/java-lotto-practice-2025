package lotto.util;

import java.util.function.Supplier;

public class RetryHandler {
    public static <T> T retryUntilSuccessWithReturn(Supplier<T> supplier) {
        while(true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
    
    public static void retryUntilSuccess(Runnable action) {
        while (true) {
            try {
                action.run();
                return;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
