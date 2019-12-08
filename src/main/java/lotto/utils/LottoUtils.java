package lotto.utils;

import lotto.domain.LottoNo;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoUtils {

    private static final Pattern ONLY_INTEGER_PATTERN = Pattern.compile("^[0-9]+$");

    private static final String LOTTO_NO_DELIMITER = ",";
    private static final String EMPTY_SPACE = " ";
    private static final String EMPTY_STRING = "";

    public static List<LottoNo> parse(String lottoNo) {
        return Arrays.stream(split(lottoNo))
                .mapToInt(LottoUtils::parseInteger)
                .mapToObj(LottoNo::of)
                .collect(Collectors.toList());
    }

    public static List<LottoNo> parse(int... lottoNo) {
        return Arrays.stream(lottoNo)
                .mapToObj(LottoNo::of)
                .collect(Collectors.toList());
    }

    private static String[] split(final String lottoNo) {
        return removeEmptySpace(lottoNo).split(LOTTO_NO_DELIMITER);
    }

    private static String removeEmptySpace(final String lottoNo) {
        return lottoNo.replaceAll(EMPTY_SPACE, EMPTY_STRING);
    }

    private static int parseInteger(String lottoNo) {
        Matcher matcher = ONLY_INTEGER_PATTERN.matcher(lottoNo);
        if (matcher.matches()) {
            return Integer.parseInt(lottoNo);
        }
        throw new NumberFormatException("문자를 정수로 Parse 할 수 없습니다.");
    }
}
