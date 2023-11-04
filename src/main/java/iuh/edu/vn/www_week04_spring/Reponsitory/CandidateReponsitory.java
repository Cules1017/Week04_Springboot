package iuh.edu.vn.www_week04_spring.Reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import iuh.edu.vn.www_week04_spring.entities.Candidate;

import java.util.UUID;
@Repository
public interface CandidateReponsitory extends CrudRepository<Candidate, Long> {

}
