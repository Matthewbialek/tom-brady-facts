package main.java.model;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;


public class Recipient {


    private final PhoneNumber number;
    private final Long id;
    private final Set<Fact> facts;


    public Recipient(long id, String number) {
        this.number = new PhoneNumber(number);
        this.facts = new HashSet<Fact>();
        this.id = id;
    }

    public void addRecievedFact(Fact fact) {
        this.facts.add(fact);
    }

    public PhoneNumber getNumber() {
        return this.number;
    }

    public Set<Fact> getFacts() {
        return this.facts;
    }

    public long getId() {
        return this.id;

    }

    public boolean sendSmsMessage(Fact fact, PhoneNumber fromNumber) {
        Message message = null;
        if (!this.facts.contains(fact)) {
            message = Message
                    .creator(this.getNumber(),  // to
                            fromNumber,  // from
                            fact.getFact())
                    .create();
            this.getFacts().add(fact);
        }
        return true;
    }


    public void sendMmsMessage(Fact fact, PhoneNumber fromNumber, URI mediaURL) throws URISyntaxException {

        if (mediaURL != null) {
            Message message = Message
                    .creator(this.getNumber(),  // to
                            fromNumber,  // from
                            fact.getFact())
                    .setMediaUrl(mediaURL)
                    .create();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipient)) return false;

        Recipient recipient = (Recipient) o;

        if (!this.id.equals(recipient.id)) return false;
        if (!this.number.equals(recipient.number)) return false;
        return this.facts.equals(recipient.facts);

    }

    @Override
    public int hashCode() {
        int result = this.id.hashCode();
        result = 31 * result + this.number.hashCode();
        result = 31 * result + this.facts.hashCode();
        return result;
    }
}
