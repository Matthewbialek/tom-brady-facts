package main.java.config;

import com.twilio.type.PhoneNumber;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:secrets.properties")
@ConfigurationProperties(prefix = "twillio")
@Component
public class TwillioConfig {
    private String number;
    private String auth;
    private String sid;
    private PhoneNumber phoneNumber;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String authId) {
        this.auth = authId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public PhoneNumber getPhoneNumber() {
        if (phoneNumber == null)
            phoneNumber = new PhoneNumber(number);
        return phoneNumber;
    }
}
