package main.java.resources;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import main.java.config.TwillioConfig;
import main.java.model.Fact;
import main.java.model.Recipient;
import main.java.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/message")
public class MessageResource {
    @Autowired
    RecipientRepository recipientRepository;

    @Autowired
    TwillioConfig twillioConfig;

    @PostMapping
    public ResponseEntity sendSmsMessage(@RequestBody String number) {

        PhoneNumber phoneNumber = new PhoneNumber(number);
        if (phoneNumber == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Recipient recipient = recipientRepository.findRecipientByNumber(number);
        if (recipient == null) {
            recipient = new Recipient();
            recipient.setNumber(number);
            recipient = recipientRepository.save(recipient);
        }

        Message message = Message
                .creator(recipient.getPhoneNumber(),  // to
                        twillioConfig.getPhoneNumber(),  // from
                        "Welcome to Tom Brady Facts")
                .create();


        return new ResponseEntity(HttpStatus.OK);
    }


    public void sendMmsMessage(Fact fact, PhoneNumber fromNumber, URI mediaURL) throws URISyntaxException {

//        if (mediaURL != null) {
//            Message message = Message
//                    .creator(this.getNumber(),  // to
//                            fromNumber,  // from
//                            fact.getFact())
//                    .setMediaUrl(mediaURL)
//                    .create();
//        }
    }
}
