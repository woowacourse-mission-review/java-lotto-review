package lotto.domain;

import static lotto.domain.LottoNo.MAX_LOTTO_NO;
import static lotto.domain.LottoNo.MIN_LOTTO_NO;

class InvalidRangeException extends RuntimeException {

    public static final String INVALID_RANGE_EXCEPTION_MESSAGE = String.format("로또 번호가 %d ~ %d 사이가 아닙니다.", MIN_LOTTO_NO, MAX_LOTTO_NO);

    InvalidRangeException() {
        super(INVALID_RANGE_EXCEPTION_MESSAGE);
    }
}
