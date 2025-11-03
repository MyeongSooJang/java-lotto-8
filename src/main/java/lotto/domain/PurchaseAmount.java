package lotto.domain;

import static lotto.constant.ErrorMessage.INVALID_PURCHASE_UNIT;
import static lotto.constant.ErrorMessage.NEGATIVE_PURCHASE_AMOUNT;
import static lotto.constant.ErrorMessage.ZERO_PURCHASE_AMOUNT;
import static lotto.constant.LottoConstant.LOTTO_PRICE;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validateNegative(purchaseAmount);
        validateZero(purchaseAmount);
        validateThousandUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateNegative(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(NEGATIVE_PURCHASE_AMOUNT);
        }
    }

    private void validateZero(int purchaseAmount) {
        if (purchaseAmount == 0) {
            throw new IllegalArgumentException(ZERO_PURCHASE_AMOUNT);
        }
    }

    private void validateThousandUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_UNIT);
        }
    }

    public int calculateLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int getAmount() {
        return purchaseAmount;
    }
}
