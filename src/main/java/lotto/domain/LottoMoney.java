package lotto.domain;

import java.util.Objects;

public class LottoMoney {
    static final int PRICE_PER_LOTTO_TICKET = 1000;
    static final String INVALID_PRICE_EXCEPTION_MESSAGE = "로또 구입 금액은 " + PRICE_PER_LOTTO_TICKET + "원 단위로 입력해야 합니다.";

    private final int value;

    private LottoMoney(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (value % PRICE_PER_LOTTO_TICKET != 0 || value == 0) {
            throw new IllegalArgumentException(INVALID_PRICE_EXCEPTION_MESSAGE);
        }
    }

    public static LottoMoney of(final int value) {
        return new LottoMoney(value);
    }

    public int value() {
        return value;
    }

    public int countOfPurchase() {
        return value / PRICE_PER_LOTTO_TICKET;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoMoney that = (LottoMoney) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LottoMoney{" +
                "value=" + value +
                '}';
    }
}
