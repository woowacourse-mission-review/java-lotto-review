package lotto.view;

import lotto.domain.lottostatistics.LottoRank;
import lotto.domain.lottostatistics.LottoStatistics;
import lotto.domain.lottoticket.PurchasedLottoTickets;

import java.util.Arrays;
import java.util.Collections;

public class OutputView {

    private static final String EXCEPTION_MESSAGE_PREFIX = "ERROR : ";
    private static final String MESSAGE_FOR_PURCHASED_LOTTO = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";

    public void showMessageOfException(final Exception e) {
        System.out.println(EXCEPTION_MESSAGE_PREFIX + e.getMessage());
    }

    public void show(final PurchasedLottoTickets purchasedLottoTickets) {
        String messageForPurchasedLotto = String.format(MESSAGE_FOR_PURCHASED_LOTTO
                , purchasedLottoTickets.sizeOfManualLottoTickets(), purchasedLottoTickets.sizeOfAutoLottoTickets());
        System.out.println(messageForPurchasedLotto);

        System.out.println(purchasedLottoTickets);
    }

    public void show(final LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoRank lottoRank : getReverseOrderedLottoRanks()) {
            long matchingCount = lottoStatistics.findMatchingCountBy(lottoRank);
            String messageOfStatisticsForRank = createMessageOfStatisticsForRank(lottoRank, matchingCount);

            System.out.println(messageOfStatisticsForRank);
        }
    }

    private LottoRank[] getReverseOrderedLottoRanks() {
        LottoRank[] allLottoRanks = LottoRank.values();
        Arrays.sort(allLottoRanks, Collections.reverseOrder());

        return allLottoRanks;
    }

    private String createMessageOfStatisticsForRank(final LottoRank lottoRank, final long matchingCount) {
        return String.format("%d개 일치%s (%d원) - %d개", lottoRank.getMatchingCount()
                , createMessageForSecondLottoRank(lottoRank), lottoRank.getPrize(), matchingCount);
    }

    private String createMessageForSecondLottoRank(final LottoRank lottoRank) {
        return LottoRank.SECOND.equals(lottoRank) ? ", 보너스 볼 일치" : "";
    }
}
