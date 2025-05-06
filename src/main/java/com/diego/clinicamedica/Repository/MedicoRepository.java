package com.diego.clinicamedica.Repository;

import com.diego.clinicamedica.Entity.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicoRepository extends MongoRepository<Medico, String> {
    List<Medico> findByNomeContainingIgnoreCase(String nome);
    List<Medico> findByEspecialidadeEqualsIgnoreCase(String especialidade);

}
