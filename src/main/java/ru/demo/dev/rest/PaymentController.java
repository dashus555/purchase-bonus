package ru.demo.dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.demo.dev.enums.PointOfSailsType;
import ru.demo.dev.enums.PurchaseStatus;
import ru.demo.dev.context.PaymentContext;
import ru.demo.dev.context.states.PaymentNew;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentContext paymentContext;

    public PaymentController(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
    }

    @GetMapping("/{pointOfSailsType}/{amount}")
    public List<String> startPayment(@PathVariable PointOfSailsType pointOfSailsType, @PathVariable double amount) {

        List<String> purchaseStatuses = new ArrayList<>(10);

        synchronized (PaymentContext.class) {
            //задаем контексту статус новой покупки
            paymentContext.setPaymentState(new PaymentNew());

            //обрабатываем платеж, пока не достигнем конечного статуса
            do {
                purchaseStatuses.add(paymentContext.getPurchaseStatus().getDescription());
                paymentContext.process(pointOfSailsType, amount);
            } while (paymentContext.getPurchaseStatus() != PurchaseStatus.NEW);
        }

        return purchaseStatuses;
    }
}
