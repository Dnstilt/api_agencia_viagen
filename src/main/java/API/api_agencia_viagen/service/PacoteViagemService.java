package API.api_agencia_viagen.service;

import API.api_agencia_viagen.entity.PacoteViagem;
import API.api_agencia_viagen.repository.PacoteViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteViagemService {

    @Autowired
    private PacoteViagemRepository pacoteViagemRepository;

    public List<PacoteViagem> findAll() {
        return pacoteViagemRepository.findAll();
    }

    public PacoteViagem findById(Long id) {
        return pacoteViagemRepository.findById(id).orElse(null);
    }

    public PacoteViagem save(PacoteViagem pacoteViagem) {
        return pacoteViagemRepository.save(pacoteViagem);
    }

    public void deleteById(Long id) {
        pacoteViagemRepository.deleteById(id);
    }
}
