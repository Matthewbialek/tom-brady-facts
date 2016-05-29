package Message;


import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

import model.Fact;
import model.Recipient;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class MessageSender{
	

	public static final String ACCOUNT_SID ="";
	public static final String AUTH_TOKEN = "";
	public static final String TWILIO_NUMBER = "";

	public MessageSender() {
	}

	public void execute(Fact fact, Recipient recip)
			throws JobExecutionException {


		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		

		
		if (fact != null) {
			
			String phoneNumber = recip.getNumber();
			
			String messageBody = fact.getFact();;

			// Build a filter for the MessageList
			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("Body", messageBody));
			params.add(new BasicNameValuePair("To", phoneNumber));
			params.add(new BasicNameValuePair("From", TWILIO_NUMBER));

			MessageFactory messageFactory = client.getAccount()
					.getMessageFactory();
			Message message = null;
			try {
				message = messageFactory.create(params);
				System.out.println(message.getSid());
			} catch (TwilioRestException e) {
				System.out
						.println("An error occurred while trying to send the message: "
								+ e.getMessage());
			}
		}
	}
}
