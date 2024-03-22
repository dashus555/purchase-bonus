package ru.demo.dev.context;

import lombok.Getter;
import lombok.Setter;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.context.states.PaymentState;
import ru.demo.dev.model.bank.Bank;
import ru.demo.dev.model.client.BankClient;
import ru.demo.dev.model.point_of_sales.PointOfSails;

import java.util.Map;

@Getter
@Setter
public class PaymentContext {

    private Bank bank;

    private BankClient bankClient;

    private Map<PointOfSailsType, PointOfSails> pointsOfSales;

    private PaymentState paymentState;

    public void process(PointOfSailsType pointOfSailsType, double amount) {
        paymentState.process(this, pointOfSailsType, amount);
    }

    public PurchaseStatus getPurchaseStatus() {
        return paymentState.getPurchaseStatus();
    }
}
