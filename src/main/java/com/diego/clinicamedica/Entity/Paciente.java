package com.diego.clinicamedica.Entity;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
}
