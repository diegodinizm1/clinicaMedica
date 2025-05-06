package com.diego.clinicamedica.Services;

import com.diego.clinicamedica.Entity.Medico;
import com.diego.clinicamedica.Repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private MedicoRepository medicoRepository;

    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    public List<Medico> listarMedicosPorNome(String nome) {
        return medicoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Medico> listarMedicosPorEspecialidade(String especialidade) {
        return medicoRepository.findByEspecialidadeEqualsIgnoreCase(especialidade);
    }

    public ResponseEntity<Medico> salvarMedico(Medico medico) {
        if (!medicoRepository.existsById(medico.getId())) {
            medicoRepository.save(medico);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Medico> deletarMedico(String id) {
        if(medicoRepository.existsById(id)){
            medicoRepository.deleteById(id);
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Medico> atualizarMedico(String id, @Valid Medico medico) {
        if(medicoRepository.existsById(id)){
            Medico medicoAtualizado = medicoRepository.findById(id).get();
            medicoAtualizado.setNome(medico.getNome());
            medicoAtualizado.setEspecialidade(medico.getEspecialidade());
            medicoAtualizado.setId(medico.getId());
            medicoAtualizado.setCpf(medico.getCpf());
            medicoAtualizado.setCrm(medico.getCrm());
            medicoAtualizado.setDisponivel(medico.isDisponivel());
            medicoRepository.save(medicoAtualizado);
            return ResponseEntity.ok(medicoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }
}
