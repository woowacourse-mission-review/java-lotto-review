package lotto.domain.exception;

import lotto.domain.lottoticket.LottoNumber;

public class InvalidLottoNumberCreationException extends IllegalArgumentException {

    public static final String INVALID_LOTTO_NUMBER_CREATION_MESSAGE = String.format("로또 숫자의 범위는 %d ~ %d 사이 입니다."
            , LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE);

    public InvalidLottoNumberCreationException() {
        super(INVALID_LOTTO_NUMBER_CREATION_MESSAGE);
    }
}
