package API.api_agencia_viagen.service;
import API.api_agencia_viagen.entity.Destino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {
    private List<Destino> destinos = new ArrayList();

    public List<Destino> getAllDestinos() {
        return this.destinos;
    }
    
    public Destino createDestino(Destino destino) {
        destinos.add(destino);
        return destino;
    }

    public Destino getDestinoById(Long id) {
        Destino destino = destinos.stream().filter(d -> d.getId() == id).findFirst().get();
        return destino;
    }
    
    public Destino updateDestino(Long id, Destino destino) {
        this.destinos = destinos.stream().map(d -> {
        if(d.getId() == id){
            return destino;
        } return d;
        }).collect(Collectors.toList());
        return destino;
    }

    public void deleteDestino(Long id) {
        destinos.removeIf(d -> d.getId() == id);
    }
}
