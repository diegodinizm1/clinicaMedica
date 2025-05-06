package com.diego.clinicamedica.Repository;

import com.diego.clinicamedica.Entity.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsultaRepository extends MongoRepository<Consulta, String> {
}
