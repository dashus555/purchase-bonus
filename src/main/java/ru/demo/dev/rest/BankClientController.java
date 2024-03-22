package ru.demo.dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.demo.dev.context.PaymentContext;

@RestController
@RequestMapping("/api")
public class BankClientController {

    private final PaymentContext paymentContext;

    public BankClientController(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
    }

    @GetMapping("/money")
    public double getBankClientMoney() {
        return paymentContext.getBankClient().getMoney();
    }
}
