package com.course.hr_payroll.services;

import com.course.hr_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {

    public Payment getPpayment(long workerId, int days) {
        return new Payment("Gustavo", 200.0, days);
    }
}
