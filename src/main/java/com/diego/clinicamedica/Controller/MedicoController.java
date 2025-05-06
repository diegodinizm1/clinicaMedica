package com.diego.clinicamedica.Controller;


import com.diego.clinicamedica.Entity.Medico;
import com.diego.clinicamedica.Services.MedicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor

public class MedicoController {

    private MedicoService medicoService;

    @GetMapping()
    public List<Medico> listarMedicos(){
        return medicoService.listarMedicos();
    }

    @GetMapping("/{nome}")
    public List<Medico> listarMedicos(@PathVariable String nome){
        return medicoService.listarMedicosPorNome(nome);
    }

    @GetMapping("/especialidades/{especialidade}")
    public List<Medico> listarMedicosPorEspecialidade(@PathVariable String especialidade){
        return medicoService.listarMedicosPorEspecialidade(especialidade);
    }

    @PostMapping()
    public ResponseEntity<Medico> salvarMedico(@Valid @RequestBody Medico medico){
        return medicoService.salvarMedico(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medico> deletarMedico(@PathVariable String id){
        return medicoService.deletarMedico(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> atualizarMedico(@PathVariable String id, @Valid @RequestBody Medico medico){
        return medicoService.atualizarMedico(id, medico);
    }


}
