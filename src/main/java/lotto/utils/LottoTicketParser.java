package lotto.utils;

import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.lottonumber.LottoNumber;
import lotto.domain.lottoticket.lottonumber.LottoNumberPool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketParser {

    private static final String LOTTO_NUMBER_DELIMITER = ",";

    private LottoTicketParser() {
    }

    public static LottoTicket parseToLottoTicket(final String input) {
        EmptyChecker.check(input);

        List<LottoNumber> lottoNumbers = parseLottoNumbers(input);
        return LottoTicket.of(lottoNumbers);
    }

    private static List<LottoNumber> parseLottoNumbers(final String input) {
        return Arrays.stream(input.split(LOTTO_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumberPool::get)
                .collect(Collectors.toList());
    }
}
