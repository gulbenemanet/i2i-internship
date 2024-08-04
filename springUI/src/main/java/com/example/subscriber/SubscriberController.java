package com.example.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubscriberController {
    @Autowired
    private SubscriberRepository repository;

    @PostMapping("/api/signUp")
    public String subscriber(@ModelAttribute("subscriber") Subscriber subscriber) {
        System.out.println("Subscriber Name: " + subscriber.getName());
        System.out.println("Subscriber Surname: " + subscriber.getSurname());
        System.out.println("MSISDN: " + subscriber.getMsisdn());
        System.out.println("Tariff ID: " + subscriber.getTarifId());
        System.out.println("Start Date: " + subscriber.getStartDate());
        repository.save(subscriber);
        return "result";
    }

}
