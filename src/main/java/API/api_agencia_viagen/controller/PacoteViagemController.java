package API.api_agencia_viagen.controller;

import API.api_agencia_viagen.entity.PacoteViagem;
import API.api_agencia_viagen.service.PacoteViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacotesViagem")
public class PacoteViagemController {

    @Autowired
    private PacoteViagemService pacoteViagemService;

    @GetMapping
    public ResponseEntity<List<PacoteViagem>> getAllPacotes() {
        List<PacoteViagem> pacotes = pacoteViagemService.findAll();
        return ResponseEntity.ok(pacotes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacoteViagem> getPacoteById(@PathVariable Long id) {
        PacoteViagem pacote = pacoteViagemService.findById(id);
        if (pacote != null) {
            return ResponseEntity.ok(pacote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PacoteViagem> createPacote(@RequestBody PacoteViagem pacoteViagem) {
        PacoteViagem novoPacote = pacoteViagemService.save(pacoteViagem);
        return ResponseEntity.status(201).body(novoPacote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacoteViagem> updatePacote(@PathVariable Long id, @RequestBody PacoteViagem pacoteViagem) {
        PacoteViagem pacoteExistente = pacoteViagemService.findById(id);
        if (pacoteExistente != null) {
            pacoteViagem.setId(id);
            pacoteViagemService.save(pacoteViagem);
            return ResponseEntity.ok(pacoteViagem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacote(@PathVariable Long id) {
        PacoteViagem pacoteExistente = pacoteViagemService.findById(id);
        if (pacoteExistente != null) {
            pacoteViagemService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
