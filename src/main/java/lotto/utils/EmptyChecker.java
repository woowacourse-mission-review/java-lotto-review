package lotto.utils;

import org.apache.commons.lang3.StringUtils;

public class EmptyChecker {

    private EmptyChecker() {
    }

    public static void check(final String input) {
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException("입력에 올바르지 않은 공백 등의 값이 있습니다.");
        }
    }
}
