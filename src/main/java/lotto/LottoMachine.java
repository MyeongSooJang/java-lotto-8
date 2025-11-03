package lotto;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.LottoBundle;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    private final LottoGenerator lottoGenerator;

    public LottoMachine() {
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        LottoBundle lottoBundle = generateLottos(purchaseAmount);

        printLottos(lottoBundle);

        WinningNumbers winningNumbers = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber(winningNumbers);

        LottoResult result = lottoBundle.checkWinning(winningNumbers, bonusNumber);

        printResult(result, purchaseAmount);
    }

    private PurchaseAmount inputPurchaseAmount() {
        while (true) {
            try {
                int amount = InputView.readPurchaseAmount();
                return new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private LottoBundle generateLottos(PurchaseAmount purchaseAmount) {
        return lottoGenerator.generate(purchaseAmount);
    }

    private void printLottos(LottoBundle lottoBundle) {
        OutputView.printPurchaseCount(lottoBundle.getSize());
        OutputView.printLottos(lottoBundle);
        System.out.println();
    }

    private WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                List<Integer> numbers = InputView.readWinningNumbers();
                return new WinningNumbers(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                int number = InputView.readBonusNumber();
                return new BonusNumber(winningNumbers, number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResult(LottoResult result, PurchaseAmount purchaseAmount) {
        OutputView.printStatistics(result);
        OutputView.printProfitRate(result, purchaseAmount);
    }
}
