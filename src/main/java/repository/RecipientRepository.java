package main.java.repository;

import main.java.model.Recipient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, Long> {

    @Query("Select a from Recipient a where a.number=?1")
    Recipient findRecipientByNumber(String number);

}
