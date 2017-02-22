package main;

import com.twilio.Twilio;

public class TomBradyFacts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String account_sid = args[0];
		String auth_token = args[1];
		Twilio.init(account_sid, auth_token);
	    String TWILIO_NUMBER = args[2];


	}

}
