package main.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TomBradyFacts {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(TomBradyFacts.class, args);
//        String account_sid = args[0];
//        String auth_token = args[1];
//        Twilio.init(account_sid, auth_token);
//        String TWILIO_NUMBER = args[2];


    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

}
