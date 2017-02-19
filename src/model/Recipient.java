package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Recipient {


	private Long id;


	private final String number;

	private final String fandom;
	private Set<Fact> facts;


	
	public Recipient(long id, String number, String fandom) {
		this.fandom = fandom;
		this.number = number;
		this.facts = new HashSet<Fact>();
		this.id = id;
	}

	public void addRecievedFact(Fact fact) {
		this.facts.add(fact);
	}

	public String getNumber() {
		return number;
	}

	public String getFandom() {
		return fandom;
	}

	public Set<Fact> getFacts() {
		return facts;
	}
	
	public long getId(){
		return id;
		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Recipient)) return false;

		Recipient recipient = (Recipient) o;

		if (!id.equals(recipient.id)) return false;
		if (!number.equals(recipient.number)) return false;
		if (!fandom.equals(recipient.fandom)) return false;
		return facts.equals(recipient.facts);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + number.hashCode();
		result = 31 * result + fandom.hashCode();
		result = 31 * result + facts.hashCode();
		return result;
	}
}
