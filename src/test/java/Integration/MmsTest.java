package test.java.Integration;


import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import main.java.config.ResourceLoader;
import main.java.model.Fact;
import main.java.model.Recipient;
import org.junit.After;
import org.junit.Before;

import java.nio.file.Paths;

/**
 * Created by mattbialek on 2/22/17.
 */
public class MmsTest {


    private ResourceLoader test;
    private String accountID;
    private String authToken;
    private PhoneNumber fromNumber;
    private PhoneNumber toNumber;


    @Before
    public void setupTest() {
        this.test = new ResourceLoader(Paths.get("/Users/mattbialek/git/tom-brady-facts/src/main/resource/facts.txt"), Paths.get("/Users/mattbialek/git/tom-brady-facts/src/main/resource/recipient.txt"));

        Twilio.init(this.accountID, this.authToken);
    }


    @After
    public void tearDown() {
        this.test = null;
    }

    // @Test
    public void sendSms() {
        Recipient recipient = new Recipient(0, this.toNumber.toString());
        recipient.sendSmsMessage(new Fact(1, "Tom Brady is the GOAT"), this.fromNumber);
    }
}
