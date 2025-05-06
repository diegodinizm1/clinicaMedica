package com.diego.clinicamedica.Services;

import com.diego.clinicamedica.Entity.Paciente;
import com.diego.clinicamedica.Repository.PacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public List<Paciente> listarTodos(){
        return pacienteRepository.findAll();
    }

    public ResponseEntity<Paciente> buscarPacientePorId(String id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        return paciente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public Paciente registrarPaciente(Paciente paciente){
        if(paciente.getNome() != null && paciente.getCpf().length() == 11 && paciente.getEmail() != null && paciente.getEndereco() != null){
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public ResponseEntity<Paciente> deletarPaciente(String id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            pacienteRepository.delete(paciente.get());
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }


    public ResponseEntity<Paciente> atualizarPaciente(String id, Paciente paciente) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if(pacienteOptional.isPresent()){
            Paciente pacienteAtual = pacienteOptional.get();
            pacienteAtual.setNome(paciente.getNome());
            pacienteAtual.setCpf(paciente.getCpf());
            pacienteAtual.setEmail(paciente.getEmail());
            pacienteAtual.setTelefone(paciente.getTelefone());
            pacienteAtual.setEndereco(paciente.getEndereco());
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    public List<Paciente> buscarPacientePorNome(String nome){
        return pacienteRepository.findByNomeContainingIgnoreCase(nome);
    }

}
