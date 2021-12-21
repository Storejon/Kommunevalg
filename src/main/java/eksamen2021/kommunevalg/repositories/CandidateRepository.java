package eksamen2021.kommunevalg.repositories;


import eksamen2021.kommunevalg.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
