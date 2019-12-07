package lotto.controller;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.SizeOfManualLotto;
import lotto.domain.lottogenerator.LottoTicketGenerator;
import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.LottoTickets;
import lotto.utils.BasicLottoInputParser;
import lotto.utils.LottoTicketParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            LottoPurchaseAmount lottoPurchaseAmount = inputLottoPurchaseAmount();
            SizeOfManualLotto sizeOfManualLotto = inputSizeOfManualLotto();

            LottoTickets manualLottoTickets = inputManualLottoTickets(sizeOfManualLotto);

        } catch (IllegalArgumentException e) {
            outputView.showMessageOfException(e);
        }
    }

    private LottoPurchaseAmount inputLottoPurchaseAmount() {
        String lottoPurchaseAmountInput = inputView.inputLottoPurchaseAmount();
        return BasicLottoInputParser.parseLottoPurchaseAmount(lottoPurchaseAmountInput);
    }

    private SizeOfManualLotto inputSizeOfManualLotto() {
        String sizeOfManualLottoInput = inputView.inputSizeOfManualLotto();
        return BasicLottoInputParser.parseSizeOfManualLotto(sizeOfManualLottoInput);
    }

    private LottoTickets inputManualLottoTickets(final SizeOfManualLotto sizeOfManualLotto) {
        inputView.showInputMessageForManualLottoTickets();

        LottoTickets manualLottoTickets = new LottoTickets();
        for (int i = 0; i < sizeOfManualLotto.getSize(); i++) {
            String manualLottoTicketInput = inputView.inputBasicString();
            LottoTicket manualLottoTicket = LottoTicketParser.parseToLottoTicket(manualLottoTicketInput);

            manualLottoTickets.append(manualLottoTicket);
        }
        return manualLottoTickets;
    }
}
