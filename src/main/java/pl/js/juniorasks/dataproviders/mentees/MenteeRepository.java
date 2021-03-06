package pl.js.juniorasks.dataproviders.mentees;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenteeRepository extends MongoRepository<MenteeDAO, String> {
}
