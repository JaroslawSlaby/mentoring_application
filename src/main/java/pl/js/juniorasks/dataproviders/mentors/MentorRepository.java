package pl.js.juniorasks.dataproviders.mentors;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends MongoRepository<MentorDAO, String> {
}
