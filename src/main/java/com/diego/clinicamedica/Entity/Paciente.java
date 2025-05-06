package com.diego.clinicamedica.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
}
