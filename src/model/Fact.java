package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fact")
public class Fact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "fact")
	public final String fact;
	
	@Column(name = "fandom")
	public final String fandom;
	
	public Fact(String fact, String fandom){
		this.fact = fact;
		this.fandom = fandom;
	}

	public Long getId() {
		return id;
	}

	public String getFact() {
		return fact;
	}

	public String getFandom() {
		return fandom;
	}
	
	
	
	

}
