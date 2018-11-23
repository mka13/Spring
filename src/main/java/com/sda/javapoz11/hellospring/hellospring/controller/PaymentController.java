package com.sda.javapoz11.hellospring.hellospring.controller;

import com.sda.javapoz11.hellospring.hellospring.Entity.Payment;
import com.sda.javapoz11.hellospring.hellospring.Service.PamentActions;
import com.sda.javapoz11.hellospring.hellospring.Service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

  private PamentActions pamentActions;
  public PaymentController (PamentActions pamentActions){
      this.pamentActions =pamentActions;
  }
@GetMapping("/payment/{id}")
public Payment paymentById(@PathVariable("id") Long id){
      return pamentActions.findById(id);
}


// w ten sposob wysyla sie poprzez oznaczone parametry
@PostMapping("/payment")
@ResponseStatus(HttpStatus.CREATED)
    public void addPayment(
            @RequestParam("client") String client,
            @RequestParam("price") Double price)
    {
        pamentActions.addPayment(client,price);

}
}
