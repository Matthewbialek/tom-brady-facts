package main.java.model;

import com.twilio.type.PhoneNumber;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;


@Entity
@Table(name = "recipient")
public class Recipient {


    private String number;
    @Transient
    private PhoneNumber phoneNumber;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Set<Fact> facts;

    public Recipient() {
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
        this.phoneNumber = new PhoneNumber(number);
    }

    public Long getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void getCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PhoneNumber getPhoneNumber() {

        if (phoneNumber == null)
            phoneNumber = new PhoneNumber(number);
        return phoneNumber;
    }
}
