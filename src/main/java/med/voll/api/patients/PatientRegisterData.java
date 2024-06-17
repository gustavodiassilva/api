package med.voll.api.patients;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.address.DataAddress;
import org.hibernate.validator.constraints.br.CPF;

public record PatientRegisterData(

        @NotBlank
        String name,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @CPF
        String cpf,

        @NotBlank
        String telefone,

        @NotNull
        @Valid
        DataAddress address
) {
}
