package com.diego.clinicamedica.Entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "medicos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    @Id
    private String id;
    @NotBlank
    private String nome;
    @NotBlank
    private String crm;
    private boolean disponivel;
    private String cpf;
    @NotBlank
    private String especialidade;
    @NotBlank
    private List<String> horariosDisponiveis;
}
