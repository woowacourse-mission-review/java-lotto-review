package lotto.utils;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.SizeOfManualLotto;
import lotto.domain.lottoticket.lottonumber.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BasicLottoInputParserTest {

    @Test
    void parseLottoPurchaseAmount() {
        LottoPurchaseAmount lottoPurchaseAmount = BasicLottoInputParser.parseLottoPurchaseAmount("14000");

        assertThat(lottoPurchaseAmount).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"string", "999", "-1000"})
    void parseLottoPurchaseAmount_exceptions(String input) {
        assertThrows(IllegalArgumentException.class, () -> BasicLottoInputParser.parseLottoPurchaseAmount(input));
    }

    @Test
    void parseSizeOfManualLotto() {
        SizeOfManualLotto sizeOfManualLotto = BasicLottoInputParser.parseSizeOfManualLotto("3");

        assertThat(sizeOfManualLotto).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"string", "-1"})
    void parseSizeOfManualLotto_exceptions(String input) {
        assertThrows(IllegalArgumentException.class, () -> BasicLottoInputParser.parseSizeOfManualLotto(input));
    }

    @Test
    void parseLottoBonusBall() {
        LottoNumber lottoNumber = BasicLottoInputParser.parseLottoBonusBall("3");

        assertThat(lottoNumber).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"string", "0", "46"})
    void parseLottoBonusBall_exceptions(String input) {
        assertThrows(IllegalArgumentException.class, () -> BasicLottoInputParser.parseLottoBonusBall(input));
    }
}