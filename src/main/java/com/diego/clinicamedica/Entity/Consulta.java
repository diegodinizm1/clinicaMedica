package com.diego.clinicamedica.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "consultas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    @Id
    private String id;
    private LocalDate dataConsulta;
    private Medico medico;
    private Paciente paciente;

}
