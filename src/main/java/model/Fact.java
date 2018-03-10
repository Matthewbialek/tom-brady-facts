package main.java.model;


public class Fact {


    public final String fact;
    private final Long id;


    public Fact(long id, String fact) {
        this.fact = fact;
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public String getFact() {
        return this.fact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fact)) return false;

        Fact fact1 = (Fact) o;

        if (!this.id.equals(fact1.id)) return false;
        return this.fact.equals(fact1.fact);

    }

    @Override
    public int hashCode() {
        int result = this.id.hashCode();
        result = 31 * result + this.fact.hashCode();
        return result;
    }
}
