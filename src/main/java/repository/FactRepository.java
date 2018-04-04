package main.java.repository;


import main.java.model.Fact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FactRepository extends CrudRepository<Fact, Long> {


    @Query("Select a from Fact a where a.state='suggested'")
    List<Fact> findSuggestedFacts();

    @Query("Select a from Fact a where a.state='active'")
    List<Fact> findActiveFacts();

    @Modifying
    @Transactional
    @Query("update Fact u set u.state = ?2 where u.id = ?1")
    int updateStateFact(Long id, Fact.FactState factState);
}
