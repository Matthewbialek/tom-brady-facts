package main.java.resources;

import io.swagger.annotations.ApiParam;
import main.java.model.Recipient;
import main.java.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.List;

@Path("/user")
public class UserResource {

    @Autowired
    private RecipientRepository repo;

    @PostMapping
    public Recipient createUser(@ApiParam(value = "The user we are adding") @Valid @RequestBody String phoneNumber) {
        Recipient recipient = new Recipient();
        recipient.setNumber(phoneNumber);
        return repo.save(recipient);
    }


    @GetMapping("/{id}")
    public Recipient getUser(@PathVariable(value = "id") Long id) {
        return repo.findById(id).get();
    }

    @GetMapping
    public List<Recipient> getAllRecipient() {
        return (List<Recipient>) repo.findAll();
    }

}
