package lotto.view;

import lotto.domain.lottoticket.PurchasedLottoTickets;

public class OutputView {

    private static final String EXCEPTION_MESSAGE_PREFIX = "ERROR : ";
    private static final String MESSAGE_FOR_PURCHASED_LOTTO = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";

    public void showMessageOfException(final Exception e) {
        System.out.println(EXCEPTION_MESSAGE_PREFIX + e.getMessage());
    }

    public void showPurchasedLottoTickets(final PurchasedLottoTickets purchasedLottoTickets) {
        String messageForPurchasedLotto = String.format(MESSAGE_FOR_PURCHASED_LOTTO
                , purchasedLottoTickets.sizeOfManualLottoTickets(), purchasedLottoTickets.sizeOfAutoLottoTickets());
        System.out.println(messageForPurchasedLotto);

        System.out.println(purchasedLottoTickets);
    }
}
