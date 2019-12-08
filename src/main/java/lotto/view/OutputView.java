package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.util.List;
import java.util.StringJoiner;

import static lotto.domain.Rank.MISS;
import static lotto.domain.Rank.SECOND;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String LOTTO_DELIMITER = ", ";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";

    public void showErrorMessage(final RuntimeException e) {
        System.out.println(e.getMessage());
    }

    public void showLottos(final List<Lotto> lottos, final int manualCount, final int autoCount) {
        System.out.println(NEW_LINE + String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualCount, autoCount));
        for (Lotto lotto : lottos) {
            StringJoiner stringJoiner = new StringJoiner(LOTTO_DELIMITER, LOTTO_PREFIX, LOTTO_SUFFIX);
            for (LottoNo lottoNo : lotto.getLottoNos()) {
                stringJoiner.add(String.valueOf(lottoNo.no()));
            }
            System.out.println(stringJoiner.toString());
        }
    }

    public void showResult(final WinningResult winningResult, final int change) {
        System.out.println(NEW_LINE + "당첨 통계");
        System.out.println("---------");
        for (Rank value : Rank.values()) {
            if (value == MISS) {
                continue;
            }
            if (value == SECOND) {
                System.out.println(String.format("%d개 일치, 보너스 볼 일치(%d원) - %d개",
                        SECOND.getCountOfMatch(),
                        SECOND.getWinningMoney(),
                        winningResult.getCountOf(value)));
            }
            System.out.println(String.format("%d개 일치 (%d원)- %d개",
                    value.getCountOfMatch(),
                    value.getWinningMoney(),
                    winningResult.getCountOf(value)));
        }
        System.out.println(NEW_LINE + String.format("총 수익률은 %d%%입니다.", winningResult.getEarningsRate()));
        System.out.println(String.format("거스름돈은 %d원입니다.", change));
    }

}
