package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "appointments")
public class Recipient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "number")
	private final String number;

	@Column(name = "fandom")
	private final String fandom;
	private Set<Fact> facts;

	public Recipient(String number, String fandom) {
		this.fandom = fandom;
		this.number = number;
		this.facts = new HashSet<Fact>();
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

}
