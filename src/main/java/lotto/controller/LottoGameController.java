package lotto.controller;

import lotto.domain.LottoPurchaseAmount;
import lotto.domain.SizeOfManualLotto;
import lotto.domain.lottogenerator.LottoRandomGenerateStrategy;
import lotto.domain.lottogenerator.LottoTicketGenerator;
import lotto.domain.lottoticket.LottoTicket;
import lotto.domain.lottoticket.LottoTickets;
import lotto.domain.lottoticket.PurchasedLottoTickets;
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
            LottoTickets autoTickets = generateAutoLottoTickets(lottoPurchaseAmount, sizeOfManualLotto);

            PurchasedLottoTickets purchasedLottoTickets = createPurchasedLottoTicketsBy(manualLottoTickets, autoTickets);

            outputView.showPurchasedLottoTickets(purchasedLottoTickets);

        } catch (IllegalArgumentException e) {
            outputView.showMessageOfException(e);
        }
    }

    private PurchasedLottoTickets createPurchasedLottoTicketsBy(final LottoTickets manualLottoTickets, final LottoTickets autoTickets) {
        PurchasedLottoTickets purchasedLottoTickets = new PurchasedLottoTickets();
        purchasedLottoTickets.appendManualLottoTickets(manualLottoTickets);
        purchasedLottoTickets.appendAutoLottoTickets(autoTickets);
        return purchasedLottoTickets;
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

    private LottoTickets generateAutoLottoTickets(final LottoPurchaseAmount lottoPurchaseAmount
            , final SizeOfManualLotto sizeOfManualLotto) {
        long sizeOfAutoTicketsAvailable = calculateSizeOfAutoTicketsAvailable(lottoPurchaseAmount, sizeOfManualLotto);

        LottoTicketGenerator lottoTicketGenerator = LottoTicketGenerator.getInstance();
        return lottoTicketGenerator.createLottoTickets(sizeOfAutoTicketsAvailable, new LottoRandomGenerateStrategy());
    }

    private long calculateSizeOfAutoTicketsAvailable(final LottoPurchaseAmount lottoPurchaseAmount
            , final SizeOfManualLotto sizeOfManualLotto) {
        long sizeOfTicketsAvailable = lottoPurchaseAmount.calculateSizeOfTicketsAvailable();
        return sizeOfTicketsAvailable - sizeOfManualLotto.getSize();
    }
}
