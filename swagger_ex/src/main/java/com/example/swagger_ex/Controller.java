package com.example.swagger_ex;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/sendVoice")
    public String sendVoice(
            @RequestParam String aNumber,
            @RequestParam String bNumber,
            @RequestParam int duration,
            @RequestParam String location) {
        return String.format("A call was made from %s to %s for %d minutes in %s.", aNumber, bNumber, duration,
                location);
    }

    @PostMapping("/sendSms")
    public String sendSms(
            @RequestParam String aNumber,
            @RequestParam String bNumber,
            @RequestParam String location) {
        return String.format("An SMS was sent from %s to %s in %s.", aNumber, bNumber, location);
    }

    @PostMapping("/sendData")
    public String sendData(
            @RequestParam String aNumber,
            @RequestParam int mb,
            @RequestParam int rg,
            @RequestParam String location) {
        return String.format("Data usage of %d MB from %s in Rating Group %d at %s.", mb, aNumber, rg, location);
    }
}
