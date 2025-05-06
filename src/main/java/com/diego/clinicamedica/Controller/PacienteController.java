package com.diego.clinicamedica.Controller;

import com.diego.clinicamedica.Entity.Paciente;
import com.diego.clinicamedica.Services.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PacienteController {

    private PacienteService pacienteService;

    @GetMapping()
    public List<Paciente> listarTodos(){
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable String id){
        return pacienteService.buscarPacientePorId(id);
    }

    @GetMapping("/{nome}")
    public List<Paciente> buscarPorNome(@PathVariable String nome){
        return pacienteService.buscarPacientePorNome(nome);
    }

    @PostMapping
    public Paciente cadastrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.registrarPaciente(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> deletarPaciente(@PathVariable String id){
        return pacienteService.deletarPaciente(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizarPaciente(@PathVariable String id, @RequestBody Paciente paciente){
        return pacienteService.atualizarPaciente(id, paciente);
    }
}
