package main.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

@SpringBootApplication
@EntityScan
@ComponentScan
@EnableJpaRepositories
@EnableAutoConfiguration
@EnableScheduling
public class TomBradyFacts extends SpringBootServletInitializer {

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SpringApplication.run(TomBradyFacts.class, args);
        //Twilio.init(twillioConfig.getSid(), twillioConfig.getAuth());
//        String account_sid = args[0];
//        String auth_token = args[1];
//        Twilio.init(account_sid, auth_token);
//        String TWILIO_NUMBER = args[2];


    }


}
