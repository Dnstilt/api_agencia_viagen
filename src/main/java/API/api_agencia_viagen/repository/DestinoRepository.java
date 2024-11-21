package API.api_agencia_viagen.repository;

import API.api_agencia_viagen.entity.Destino;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {
    List<Destino> findByNomeContainingIgnoreCase(String nome);
    List<Destino> findByLocalizacaoContainingIgnoreCase(String localizacao);
}
