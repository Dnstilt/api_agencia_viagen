package API.api_agencia_viagen.service;
import API.api_agencia_viagen.entity.Destino;
import API.api_agencia_viagen.repository.DestinoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DestinoService {
    
    @Autowired
    private DestinoRepository destinoRepository;

    public List<Destino> getAllDestinos() {
        return destinoRepository.findAll();
    }
    
    public Destino createDestino(Destino destino) {
        destinoRepository.save(destino);
        return destino;
    }

    public Optional<Destino> getDestinoById(Long id) {
        return destinoRepository.findById(id);
    }
    
    public Destino updateDestino(Long id, Destino destino) {
        destino.setId(id);
        destinoRepository.save(destino);
        return destino;
    }

    public void deleteDestino(Long id) {
        destinoRepository.deleteById(id);;
    }
}
