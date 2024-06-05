package com.course.hr_payroll.entities;

import java.io.Serializable;
import java.util.Objects;

public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Double dayilyIncome;
    private Integer days;

    public Payment() {

    }

    public Payment(String name, Double dayilyIncome, Integer days) {
        this.name = name;
        this.dayilyIncome = dayilyIncome;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDayilyIncome() {
        return dayilyIncome;
    }

    public void setDayilyIncome(Double dayilyIncome) {
        this.dayilyIncome = dayilyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(name, payment.name) && Objects.equals(dayilyIncome, payment.dayilyIncome) && Objects.equals(days, payment.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dayilyIncome, days);
    }

    public double getTotal() {
        return  days * dayilyIncome;
    }
}
