package API.api_agencia_viagen.controller;

import API.api_agencia_viagen.entity.Destino;
import API.api_agencia_viagen.service.DestinoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Destino destino = destinoService.getDestinoById(id);
        return new ResponseEntity<>(destino, HttpStatus.OK);
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
}
