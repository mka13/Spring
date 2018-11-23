package com.sda.javapoz11.hellospring.hellospring.repository;

import com.sda.javapoz11.hellospring.hellospring.Entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.Entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment,Long> {

}
