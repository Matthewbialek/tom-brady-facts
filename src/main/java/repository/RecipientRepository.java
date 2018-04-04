package main.java.repository;

import main.java.model.Recipient;
import org.springframework.data.repository.CrudRepository;

interface RecipientRepository extends CrudRepository<Recipient, Long> {

}
