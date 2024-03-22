package ru.demo.dev.enums;

import lombok.Getter;

@Getter
public enum PurchaseStatus {
    NEW("Новая покупка"),
    PROCESSING("Обработка платежа"),
    POINT_OF_SALES_BONUS("Начисление бонусов точке продажи"),
    COMMISSION("Взятие комиссии за сумму покупки"),
    REFUND("Возврат денежных средств"),
    BANK_BONUS("Бонусы за сумму покупки"),
    COMPLETED("Покупка завершена");

    private final String description;

    PurchaseStatus(String description) {
        this.description = description;
    }
}
