package com.sda.javapoz11.hellospring.hellospring.Service;

import com.sda.javapoz11.hellospring.hellospring.Entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.Entity.Status;
import com.sda.javapoz11.hellospring.hellospring.repository.PaymentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
@Profile("!dev")
@Service
public class PaymentService implements PamentActions {
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void addPayment(String client, Double price) {
        Payment payment = new Payment(null, client, price, Instant.now(), Status.Inprogress);
        paymentRepository.save(payment);


    }

    @Override
    public Payment findById(long id) {
        return paymentRepository.findById(id)
                .orElse(null);
    }

    @PostConstruct
    public void init(){
        paymentRepository.save(Payment.builder()
                .client("Kowalksi Jan")
                .price(45.0)
                .date(Instant.now().minusSeconds(7*24*60*60))
        .status(Status.Inprogress)
        .build());

        paymentRepository.save(Payment.builder()
                .client("Kowalksi Jan")
                .price(30.0)
                .date(Instant.now().minusSeconds(7*24*60*60))
                .status(Status.Inprogress)
                .build());
        paymentRepository.save(Payment.builder()
                .client("Ewa Wisniewska")
                .price(55.0)
                .date(Instant.now().minusSeconds(7*24*60*60))
                .status(Status.Done)
                .build());

    }

}
