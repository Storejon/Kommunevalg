package eksamen2021.kommunevalg.repositories;

import eksamen2021.kommunevalg.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Integer> {
}
