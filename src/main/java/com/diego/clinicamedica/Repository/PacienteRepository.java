package com.diego.clinicamedica.Repository;

import com.diego.clinicamedica.Entity.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PacienteRepository extends MongoRepository<Paciente, String> {

    List<Paciente> findByNomeContainingIgnoreCase(String nome);
    List<Paciente> findByCpfIgnoreCase(String cpf);

}
