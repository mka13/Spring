package com.sda.javapoz11.hellospring.hellospring.controller;

import com.sda.javapoz11.hellospring.hellospring.Service.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {
  // @Qualifier ("bigNumbersGenerator") mówi springowi jaka ma być nazwa wstrzykiwanego beana
    @Autowired // mówi springowi żeby w to pole wstryknąć obiekt (bean) - autowired stosować tylko na konstrutkorze
    private RandomGenerator randomGenerator;

    //wstrzykanie wszyskitch beanow typu randomGenerator:
    @Autowired
    private List<RandomGenerator> randomGeneratorList;


    @GetMapping("/hello")
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView("hello.html");
        modelAndView.addObject("message","Ala ma kota");
        return modelAndView;

    }
}
