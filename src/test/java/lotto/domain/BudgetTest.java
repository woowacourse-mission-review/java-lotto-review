package lotto.domain;

import lotto.exception.NegativeBudgetException;
import lotto.exception.NoMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.exception.NegativeBudgetException.NEGATIVE_BUDGET_EXCEPTION_MESSAGE;
import static lotto.exception.NoMoneyException.NO_MONEY_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {

    @DisplayName("정상적으로 Budget 생성")
    @Test
    void generate_budget() {
        assertDoesNotThrow(() -> Budget.of(LOTTO_PRICE));
    }

    @DisplayName("로또 가격보다 낮은 구입 금액 입력시 Budget 생성 에러")
    @Test
    void generate_budget_with_under_lotto_price() {
        NoMoneyException e = assertThrows(NoMoneyException.class, () -> Budget.of(LOTTO_PRICE - 1));
        assertEquals(e.getMessage(), NO_MONEY_EXCEPTION_MESSAGE);
    }

    @DisplayName("음수의 구입 금액 입력시 Budget 생성 에러")
    @Test
    void generate_budget_with_negative() {
        NoMoneyException e = assertThrows(NoMoneyException.class, () -> Budget.of(-1));
        assertEquals(e.getMessage(), NO_MONEY_EXCEPTION_MESSAGE);
    }

    @DisplayName("Budget 의 돈보다 적은 수의 로또 구매 갯수를 입력하는 경우 로또를 살 수 있는지")
    @Test
    void can_buy_lotto_if_budget_more_than_purchasing_money() {
        Budget budget = Budget.of(4001);
        assertDoesNotThrow(() -> budget.validateAffordabilityCountOf(4));
    }

    @DisplayName("Budget 의 돈보다 큰 수의 로또 구매 갯수를 입력하는 경우 로또를 살 수 없는지")
    @Test
    void cannot_buy_lotto_if_budget_less_than_purchasing_money() {
        Budget budget = Budget.of(4999);
        NoMoneyException e = assertThrows(NoMoneyException.class, () -> budget.validateAffordabilityCountOf(5));
        assertEquals(e.getMessage(), NO_MONEY_EXCEPTION_MESSAGE);
    }

    @DisplayName("구입 가능한 로또의 갯수")
    @Test
    void get_count_of_affordable_lotto_purchasing_money() {
        Budget budget = Budget.of(2000);
        assertEquals(budget.getAffordableLottoPurchasingMoney(), 2);
    }

    @DisplayName("pay() 메서드로부터 리턴된 Budget 객체의 금액이 줄어들었는지 확인")
    @Test
    void after_pay_returning_budget() {
        Budget beforeBudget = Budget.of(4500);
        Budget afterBudget = beforeBudget.pay(4);

        assertEquals(beforeBudget.budget(), 4500);
        assertEquals(afterBudget.budget(), 500);
    }

    @DisplayName("pay() 메서드로부터 Budget 객체 생성 시 마이너스 금액을 입력하는 경우 에러")
    @Test
    void after_pay_returning_budget_negative_money_error() {
        Budget beforeBudget = Budget.of(4500);

        NegativeBudgetException e = assertThrows(NegativeBudgetException.class, () -> beforeBudget.pay(5));
        assertEquals(e.getMessage(), NEGATIVE_BUDGET_EXCEPTION_MESSAGE);
    }
}