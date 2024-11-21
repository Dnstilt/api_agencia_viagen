package API.api_agencia_viagen.repository;

import API.api_agencia_viagen.entity.PacoteViagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteViagemRepository extends JpaRepository<PacoteViagem, Long> {
}
