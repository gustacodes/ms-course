package com.course.hr_payroll.resources;

import com.course.hr_payroll.entities.Payment;
import com.course.hr_payroll.services.PaymentServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentServices paymentServices;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) throws InterruptedException {
        Payment payment = paymentServices.getPayment(workerId, days);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
        Payment payment = new Payment("Fernanda", 400., days);
        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

}
