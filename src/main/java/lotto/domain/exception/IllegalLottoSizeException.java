package lotto.domain.exception;

import lotto.domain.lottoticket.LottoTicket;

public class IllegalLottoSizeException extends IllegalArgumentException {

    public static final String ILLEGAL_LOTTO_SIZE_MESSAGE
            = String.format("로또 숫자는 %d개의 숫자입니다.", LottoTicket.SIZE_OF_LOTTO_TICKETS);

    public IllegalLottoSizeException() {
        super(ILLEGAL_LOTTO_SIZE_MESSAGE);
    }
}
