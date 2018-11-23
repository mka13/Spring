package com.sda.javapoz11.hellospring.hellospring.Service;

import com.sda.javapoz11.hellospring.hellospring.Entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


public interface PamentActions {



void addPayment(String client,Double price);

Payment findById(long id);


}
