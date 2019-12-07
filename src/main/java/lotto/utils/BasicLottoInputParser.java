package lotto.utils;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.SizeOfManualLotto;
import lotto.domain.lottoticket.lottonumber.LottoNumber;
import lotto.domain.lottoticket.lottonumber.LottoNumberPool;

import java.util.function.IntFunction;
import java.util.stream.Stream;

public class BasicLottoInputParser {

    private BasicLottoInputParser() {
    }

    public static LottoPurchaseAmount parseLottoPurchaseAmount(final String input) {
        return parseWithCheckingEmpty(input, LottoPurchaseAmount::from);
    }

    public static SizeOfManualLotto parseSizeOfManualLotto(final String input) {
        return parseWithCheckingEmpty(input, SizeOfManualLotto::from);
    }

    public static LottoNumber parseLottoBonusBall(final String input) {
        return parseWithCheckingEmpty(input, LottoNumberPool::get);
    }

    private static <T> T parseWithCheckingEmpty(final String input, final IntFunction<T> creationFunction) {
        EmptyChecker.check(input);

        return parse(input, creationFunction);
    }

    private static <T> T parse(final String input, final IntFunction<T> creationFunction) {
        return Stream.of(input)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(creationFunction::apply)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
