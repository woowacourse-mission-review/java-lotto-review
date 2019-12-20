package lotto.console;

import lotto.console.view.InputView;
import lotto.console.view.OutputView;
import lotto.domain.*;
import lotto.domain.factory.AutoLottoTicketFactory;
import lotto.domain.factory.LottoTicketsFactory;
import lotto.domain.factory.ShuffleRandomStrategy;
import lotto.domain.factory.ShuffleStrategy;

import java.util.List;

public class ConsoleApp {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private static final ShuffleStrategy shuffleStrategy = ShuffleRandomStrategy.getInstance();
    private static final AutoLottoTicketFactory autoLottoTicketFactory = new AutoLottoTicketFactory(shuffleStrategy);
    private static final LottoTicketsFactory lottoTicketsFactory = new LottoTicketsFactory(autoLottoTicketFactory);

    public static void main(String[] args) {
        try {
            final LottoMoney lottoMoney = inputLottoMoney();

            final CountOfManualLotto countOfManualLotto = inputCountOfManualLotto(lottoMoney);
            final List<String> inputManualLottoTickets = inputView.inputManualLotto(countOfManualLotto.value());
            final LottoTickets lottoTickets = lottoTicketsFactory.create(inputManualLottoTickets, lottoMoney);

            outputView.printLottoTickets(lottoTickets, countOfManualLotto, lottoMoney);

            final LottoTicket winningLottoTicket = inputWinningLottoTicket();
            final LottoNumber bonusNumber = inputBonusNumber();
            final WinningLotto winningLotto = WinningLotto.of(winningLottoTicket, bonusNumber);

            final Result result = lottoTickets.match(winningLotto);

            outputView.printResult(result);
            outputView.printRateOfProfit(result, lottoMoney);

        } catch (Exception ex) {
            outputView.printException(ex);
        }
    }

    private static LottoMoney inputLottoMoney() {
        final String money = inputView.inputMoney();
        return LottoMoney.of(Integer.parseInt(money));
    }

    private static CountOfManualLotto inputCountOfManualLotto(final LottoMoney lottoMoney) {
        final String inputCountOfManualLotto = inputView.inputCountOfManualLotto();
        return CountOfManualLotto.of(Integer.parseInt(inputCountOfManualLotto), lottoMoney.countOfPurchase());
    }

    private static LottoTicket inputWinningLottoTicket() {
        return LottoTicket.of(LottoUtils.parseLottoNumbers(inputView.inputWinningLotto()));
    }

    private static LottoNumber inputBonusNumber() {
        return LottoNumber.of(Integer.parseInt(inputView.inputBonusNo()));
    }
}
