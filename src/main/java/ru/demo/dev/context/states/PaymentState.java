package ru.demo.dev.context.states;

import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.context.PaymentContext;

public interface PaymentState {

    /**
     * Обработка текущего статуса покупки
     * @param paymentContext контекст обработки платежа
     * @param pointOfSailsType тип магазина, в котором совершена покупка
     * @param amount сумма покупки
     */
    void process(PaymentContext paymentContext, PointOfSailsType pointOfSailsType, double amount);

    PurchaseStatus getPurchaseStatus();
}
