package main.java.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Streams;
import com.twilio.rest.api.v2010.account.Message;
import main.java.config.TwillioConfig;
import main.java.model.Fact;
import main.java.model.Recipient;
import main.java.repository.FactRepository;
import main.java.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageScheduling {

    @Autowired
    private FactRepository factRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    @Autowired
    TwillioConfig twillioConfig;

    @Scheduled(cron = "0 0 12 * * *")
    public void sendMessages() {
        Fact fact = factRepository.getRandomFact();
        Iterable<Recipient> recipients = recipientRepository.findAll();
        Streams.stream(recipients.iterator()).forEach(recipient -> sendMessage(recipient, fact));
    }


    private Message sendMessage(Recipient recipient, Fact fact) {

        return Message
                .creator(recipient.getPhoneNumber(),  // to
                        twillioConfig.getPhoneNumber(),  // from
                        fact.getFact())
                .create();
    }

    public boolean sendMessageToRecpient(Recipient recipient, Fact fact) {
        Message message = sendMessage(recipient, fact);
        return !(message.getErrorCode() != null || Strings.isNullOrEmpty(message.getErrorMessage()));
    }
}


