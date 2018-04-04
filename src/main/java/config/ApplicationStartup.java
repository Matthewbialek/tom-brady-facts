package main.java.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationStartup
        implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    TwillioConfig twillioConfig;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        Twilio.init(twillioConfig.getSid(), twillioConfig.getAuth());

        return;
    }

}