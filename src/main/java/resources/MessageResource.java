package main.java.resources;

import com.twilio.type.PhoneNumber;
import main.java.controller.MessageScheduling;
import main.java.model.Fact;
import main.java.model.Recipient;
import main.java.repository.FactRepository;
import main.java.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;


@RestController
@RequestMapping("/message")
public class MessageResource {
    private static Fact firstFact;

    static {
        firstFact = new Fact();
        firstFact.setFact("Welcome to Tom Brady Facts your source for information about the GOAT");
    }

    @Autowired
    RecipientRepository recipientRepository;

    @Autowired
    FactRepository factRepository;

    @Autowired
    MessageScheduling messaging;

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
        messaging.sendMessageToRecpient(recipient, MessageResource.firstFact);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity sendMmsMessageTest(@RequestBody String number) throws URISyntaxException {

        PhoneNumber phoneNumber = new PhoneNumber(number);
        if (phoneNumber == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Recipient recipient = recipientRepository.findRecipientByNumber(number);
        if (recipient == null) {
            recipient = new Recipient();
            recipient.setNumber(number);
            recipient = recipientRepository.save(recipient);
        }
        messaging.sendMessageToRecpient(recipient, factRepository.getRandomFact());

        return new ResponseEntity(HttpStatus.OK);
    }

}
