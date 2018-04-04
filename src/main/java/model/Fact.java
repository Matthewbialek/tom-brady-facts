package main.java.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "fact")
public class Fact {


    public enum FactState {
        ACTIVE("active"),
        SUGGESTED("suggested");


        private final String state;

        FactState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

    }

    private String fact;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Instant createdAt;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private FactState state;

    public Fact() {

    }

    public String getFact() {
        return this.fact;
    }


    public void setFact(String fact) {
        this.fact = fact;
    }

    public FactState getState() {
        return state;
    }

    public void setState(FactState state) {
        this.state = state;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }
}
