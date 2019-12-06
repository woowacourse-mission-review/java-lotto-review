package lotto.domain;

import lotto.domain.exception.LackOfManualLottoSizeException;

public class SizeOfManualLotto {

    public static final long MIN_SIZE_OF_MANUAL_LOTTO = 0;

    private final long size;

    public SizeOfManualLotto(final long size) {
        if (isLowerThanMinSize(size)) {
            throw new LackOfManualLottoSizeException();
        }

        this.size = size;
    }

    private boolean isLowerThanMinSize(final long size) {
        return size < MIN_SIZE_OF_MANUAL_LOTTO;
    }

    public static SizeOfManualLotto from(final long size) {
        return new SizeOfManualLotto(size);
    }
}
