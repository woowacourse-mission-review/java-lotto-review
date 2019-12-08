package lotto.controller;

import com.google.common.collect.Lists;
import lotto.domain.*;
import lotto.utils.LottoUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.LottoUtils.parse;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Budget initialBudget = createBudget();

        int manualCount = getManualPurchasingCount(initialBudget);
        Budget afterManualPurchaseBudget = initialBudget.pay(manualCount);
        LottoContainer manualLottoContainer = createLottoContainer(manualCount);

        int autoCount = afterManualPurchaseBudget.getAffordableLottoPurchasingCount();
        Budget afterAutoPurchaseBudget = afterManualPurchaseBudget.pay(autoCount);
        LottoContainer totalLottoContainer = new LottoContainer(manualLottoContainer,
                randomLottoGenerator.generateLottos(autoCount));

        outputView.showLottos(totalLottoContainer.getLottos(), manualCount, autoCount);

        WinningLotto winningLotto = createWinningLotto();
        WinningResult winningResult = totalLottoContainer.createResult(winningLotto);

        outputView.showResult(winningResult, afterAutoPurchaseBudget.budget());
    }


    private Budget createBudget() {
        try {
            return Budget.of(inputView.inputBudget());
        } catch (RuntimeException e) {
            outputView.showErrorMessage(e);
            return createBudget();
        }
    }

    private int getManualPurchasingCount(final Budget budget) {
        try {
            int inputManualPurchasingCount = inputView.inputManualPurchasingCount();
            budget.validateAffordabilityCountOf(inputManualPurchasingCount);
            return inputManualPurchasingCount;
        } catch (RuntimeException e) {
            outputView.showErrorMessage(e);
            return getManualPurchasingCount(budget);
        }
    }

    private LottoContainer createLottoContainer(final int manualCount) {
        if (manualCount == 0) {
            return new LottoContainer(Lists.newArrayList());
        }
        try {
            List<Lotto> inputLotto = inputView.inputManualLotto(manualCount).stream()
                    .map(LottoUtils::parse)
                    .map(Lotto::of)
                    .collect(Collectors.toList());
            return new LottoContainer(inputLotto);
        } catch (RuntimeException e) {
            outputView.showErrorMessage(e);
            return createLottoContainer(manualCount);
        }
    }

    private WinningLotto createWinningLotto() {
        try {
            List<LottoNo> winningLottoNos = parse(inputView.inputWinningLottoNos());
            LottoNo bonusNo = LottoNo.of(inputView.inputBonusNo());
            return WinningLotto.of(winningLottoNos, bonusNo);
        } catch (RuntimeException e) {
            outputView.showErrorMessage(e);
            return createWinningLotto();
        }
    }
}
