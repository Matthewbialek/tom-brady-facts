package test.Integration;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import main.config.ResourceLoader;
import main.model.Fact;
import main.model.Recipient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * Created by mattbialek on 2/22/17.
 */
public class MmsTest {

    String accountID = "ACd6a56aea5650249412c4920325d6c091";
    String authToken = "815d36e83a550445d1a575364d70ecbe";
    PhoneNumber fromNumber = new PhoneNumber("+19786753378");
    PhoneNumber toNumber = new PhoneNumber("+19782902002");
    private ResourceLoader test;


    @Before
    public void setupTest(){
        test = new ResourceLoader(Paths.get("/Users/mattbialek/git/tom-brady-facts/src/main/resource/facts.txt"), Paths.get("/Users/mattbialek/git/tom-brady-facts/src/main/resource/recipient.txt"));
        Twilio.init(accountID, authToken);
    }


    @After
    public void tearDown(){
        test= null;
    }

    @Test
    public void sendSms(){
        Recipient recipient = new Recipient(0,toNumber.toString());
        recipient.sendSmsMessage(new Fact(1,"Tom Brady is the GOAT"),fromNumber );
    }
}
