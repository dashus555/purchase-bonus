package ru.demo.dev.context.states;

import lombok.extern.slf4j.Slf4j;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.context.PaymentContext;

/**
 * Новая покупка
 */
@Slf4j
public class PaymentNew implements PaymentState {

    @Override
    public void process(PaymentContext paymentContext, PointOfSailsType pointOfSailsType, double amount) {
        log.info("Новая покупка в {}, сумма платежа = {}", pointOfSailsType.name(), amount);

        //добавляем сумму в список покупок клиента
        paymentContext.getBankClient().getAmountsOfPurchases().add(amount);

        //следующий шаг - обработка платежа
        paymentContext.setPaymentState(new PaymentProcessing());
    }

    @Override
    public PurchaseStatus getPurchaseStatus() {
        return PurchaseStatus.NEW;
    }
}
