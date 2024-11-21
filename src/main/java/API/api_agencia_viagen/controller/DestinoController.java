package API.api_agencia_viagen.controller;

import API.api_agencia_viagen.entity.Destino;
import API.api_agencia_viagen.service.DestinoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinos")
public class DestinoController {
    
    @Autowired
    public DestinoService destinoService;
    @GetMapping
    public ResponseEntity<List<Destino>> getAllDestinos(){
        List<Destino> destinos = destinoService.getAllDestinos();
        return new ResponseEntity<>(destinos, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Destino> createDestino(@RequestBody Destino destino) {
        destinoService.createDestino(destino);
        return new ResponseEntity<>(destino, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> getDestinoById(@PathVariable Long id) {
        Optional<Destino> destino = destinoService.getDestinoById(id);
            if(destino.isPresent()) {
                return new ResponseEntity<>(destino.get(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(new Destino(), HttpStatus.NO_CONTENT);
            }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destino> updateDestino(@PathVariable Long id, @RequestBody Destino destino) {
        destinoService.updateDestino(id, destino);
        return new ResponseEntity<>(destino, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestino(@PathVariable Long id) {
        destinoService.deleteDestino(id);;
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/buscarPorNome/{nome}")
    public ResponseEntity<List<Destino>> buscarPorNome(@PathVariable String nome) {
        List<Destino> destinos = destinoService.findByNome(nome);
        return ResponseEntity.ok(destinos);
    }

    @GetMapping("/buscarPorLocalizacao/{localizacao}")
    public ResponseEntity<List<Destino>> buscarPorLocalizacao(@PathVariable String localizacao) {
        List<Destino> destinos = destinoService.findByLocalizacao(localizacao);
        return ResponseEntity.ok(destinos);
    }
    @GetMapping("/{id}/descricao")
    public ResponseEntity<String> getDescricaoById(@PathVariable Long id) {
        Optional<Destino> destino = destinoService.getDestinoById(id);
            if(destino.isPresent()) {
                return new ResponseEntity<>(destino.get().getDescricao(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

}
