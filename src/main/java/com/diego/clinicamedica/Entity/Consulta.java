package com.diego.clinicamedica.Entity;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private LocalDate dataConsulta;
    @NotBlank
    private Medico medico;
    @NotBlank
    private Paciente paciente;
    @Min(1)
    private Double valorConsulta;
    @NotBlank
    private String descricaoPacienteConsulta;
}
