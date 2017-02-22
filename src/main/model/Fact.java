package main.model;


public class Fact {
	

	private Long id;

	public final String fact;


	
	public Fact(long id, String fact){
		this.fact = fact;
		this.id=id;
	}

	public Long getId() {
		return id;
	}

	public String getFact() {
		return fact;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Fact)) return false;

		Fact fact1 = (Fact) o;

		if (!id.equals(fact1.id)) return false;
		return fact.equals(fact1.fact);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + fact.hashCode();
		return result;
	}
}
