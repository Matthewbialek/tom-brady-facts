package main.java.resources;

import io.swagger.annotations.ApiParam;
import main.java.model.Fact;
import main.java.repository.FactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/fact")
@Produces({MediaType.APPLICATION_JSON})
public class FactResource {

    @Autowired
    private FactRepository factRepository;


    @PostMapping
    public Fact createFact(@ApiParam(value = "The fact we are adding") @Valid @RequestBody String factString) {
        Fact fact = new Fact();
        fact.setState(Fact.FactState.SUGGESTED);
        fact.setFact(factString.trim());
        return factRepository.save(fact);
    }


    @GetMapping("/{id}")
    public Fact getFact(@PathVariable(value = "id") Long id) {
        return factRepository.findById(id).get();
    }

    @GetMapping
    public List<Fact> getActive() {
        return factRepository.findActiveFacts();
    }


    @GetMapping("/suggested")
    public List<Fact> getSuggestedFacts() {
        return factRepository.findSuggestedFacts();
    }

    @PutMapping
    public int approveFact(Long id) {
        return factRepository.updateStateFact(id, Fact.FactState.ACTIVE);
    }


}
