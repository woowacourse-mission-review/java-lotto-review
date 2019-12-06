package lotto.domain.exception;

import lotto.domain.SizeOfManualLotto;

public class LackOfManualLottoSizeException extends IllegalArgumentException {

    public static final String LACK_OF_MANUAL_LOTTO_SIZE_MESSAGE
            = String.format("수동 로또의 구매 매수는 최소 %d 이상입니다.", SizeOfManualLotto.MIN_SIZE_OF_MANUAL_LOTTO);

    public LackOfManualLottoSizeException() {
        super(LACK_OF_MANUAL_LOTTO_SIZE_MESSAGE);
    }
}
