package main.model;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;


public class Recipient {


	private Long id;


	private final PhoneNumber number;

	private Set<Fact> facts;


	
	public Recipient(long id, String number) {
		this.number = new PhoneNumber(number);
		this.facts = new HashSet<Fact>();
		this.id = id;
	}

	public void addRecievedFact(Fact fact) {
		this.facts.add(fact);
	}

	public PhoneNumber getNumber() {
		return number;
	}

	public Set<Fact> getFacts() {
		return facts;
	}
	
	public long getId(){
		return id;
		
	}

	public boolean sendSmsMessage(Fact fact, PhoneNumber fromNumber){
        Message message = null;
        if(!facts.contains(fact)) {
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

        if(mediaURL != null) {
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

		if (!id.equals(recipient.id)) return false;
		if (!number.equals(recipient.number)) return false;
		return facts.equals(recipient.facts);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + number.hashCode();
		result = 31 * result + facts.hashCode();
		return result;
	}
}
