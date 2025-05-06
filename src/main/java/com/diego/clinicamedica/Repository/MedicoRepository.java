package com.diego.clinicamedica.Repository;

import com.diego.clinicamedica.Entity.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicoRepository extends MongoRepository<Medico, String> {
}
