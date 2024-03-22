package ru.demo.dev.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import ru.demo.dev.context.PaymentContext;
import ru.demo.dev.test.configuration.TestConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestConfig.class)
public class PaymentControllerTest {

    @Autowired
    TestRestTemplate template;

    @Autowired
    PaymentContext paymentContext;

    @Test
    public void testPayments() {

        ResponseEntity<String[]> res1 = template.getForEntity("/api/payment/ONLINE/100", String[].class);
        assertEquals(paymentContext.getBankClient().getMoney(), 4900);
        assertEquals(paymentContext.getBank().getBankAccountOfEMoney(), 0);

        ResponseEntity<String[]> res2 = template.getForEntity("/api/payment/SHOP/120", String[].class);
        assertEquals(paymentContext.getBankClient().getMoney(), 4780);
        assertEquals(paymentContext.getBank().getBankAccountOfEMoney(), 0);

        ResponseEntity<String[]> res3 = template.getForEntity("/api/payment/ONLINE/301", String[].class);
        assertEquals(paymentContext.getBankClient().getMoney(), 4479);
        assertEquals(paymentContext.getBank().getBankAccountOfEMoney(), 90.3);

        ResponseEntity<String[]> res4 = template.getForEntity("/api/payment/ONLINE/17", String[].class);
        assertEquals(paymentContext.getBankClient().getMoney(), 4462);
        assertEquals(paymentContext.getBank().getBankAccountOfEMoney(), 90.3);

        ResponseEntity<String[]> res5 = template.getForEntity("/api/payment/SHOP/1000", String[].class);
        assertEquals(paymentContext.getBankClient().getMoney(), 3462);
        assertEquals(paymentContext.getBank().getBankAccountOfEMoney(), 390.3);

        ResponseEntity<String[]> res6 = template.getForEntity("/api/payment/ONLINE/21", String[].class);
        assertEquals(paymentContext.getBankClient().getMoney(), 3441);
        assertEquals(paymentContext.getBank().getBankAccountOfEMoney(), 390.3);

        ResponseEntity<String[]> res7 = template.getForEntity("/api/payment/SHOP/570", String[].class);
        assertEquals(paymentContext.getBankClient().getMoney(), 2871);
        assertEquals(paymentContext.getBank().getBankAccountOfEMoney(), 561.3);

        ResponseEntity<String[]> res8 = template.getForEntity("/api/payment/ONLINE/700", String[].class);
        assertEquals(paymentContext.getBankClient().getMoney(), 2171);
        assertEquals(paymentContext.getBank().getBankAccountOfEMoney(), 771.3);
    }
}
