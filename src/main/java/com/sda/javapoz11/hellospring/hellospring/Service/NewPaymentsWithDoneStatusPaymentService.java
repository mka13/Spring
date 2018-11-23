package com.sda.javapoz11.hellospring.hellospring.Service;

import com.sda.javapoz11.hellospring.hellospring.Entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.Entity.Status;
import com.sda.javapoz11.hellospring.hellospring.repository.PaymentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.Instant;
@Profile("dev")
@Service
public class NewPaymentsWithDoneStatusPaymentService implements PamentActions {
    private PaymentRepository paymentRepository;

    public NewPaymentsWithDoneStatusPaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void addPayment(String client, Double price) {
       paymentRepository.save( new Payment(null,client,price, Instant.now(), Status.Done));

    }

    @Override
    public Payment findById(long id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
