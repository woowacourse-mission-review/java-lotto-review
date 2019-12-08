package lotto.console.view;

import lotto.domain.CountOfManualLotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTickets;
import lotto.domain.Result;

public class OutputView {
    private static final String NEW_LINE = "\n";

    public void printLottoTickets(final LottoTickets lottoTickets, final CountOfManualLotto countOfManualLotto, final LottoMoney lottoMoney) {
        StringBuilder sb = new StringBuilder();

        final int countOfAutoLotto = lottoMoney.countOfPurchase() - countOfManualLotto.value();
        sb.append(String.format("수동으로 %d장, 자동으로 %d장을 구매했습니다.", countOfManualLotto.value(), countOfAutoLotto));
        sb.append(NEW_LINE);
        lottoTickets.forEach(lottoTicket -> sb.append(lottoTicket).append(NEW_LINE));

        System.out.println(sb.toString());
    }

    public void printResult(final Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        ResultFormat.format(result).forEach(System.out::println);
    }

    public void printRateOfProfit(final Result result, final LottoMoney lottoMoney) {
        final double returnOfRate = result.calculateReturnOfRate(lottoMoney);
        System.out.println("총 수익률은 " + returnOfRate + "%입니다.");
    }

    public void printException(final Exception exception) {
        System.err.println(exception.getMessage());
    }
}
