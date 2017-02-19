package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Fact {
	

	private Long id;

	public final String fact;

	public final String fandom;
	
	public Fact(String fact, String fandom){
		this.fact = fact;
		this.fandom = fandom;
	}
	
	public Fact(long id, String fact, String fandom){
		this.fact = fact;
		this.fandom = fandom;
		this.id=id;
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


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Fact)) return false;

		Fact fact1 = (Fact) o;

		if (!id.equals(fact1.id)) return false;
		if (!fact.equals(fact1.fact)) return false;
		return fandom.equals(fact1.fandom);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + fact.hashCode();
		result = 31 * result + fandom.hashCode();
		return result;
	}
}
