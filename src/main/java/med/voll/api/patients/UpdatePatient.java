package med.voll.api.patients;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.DataAddress;

public record UpdatePatient(@NotNull Long id, String name, String email, String telefone, DataAddress endereco) {
}
