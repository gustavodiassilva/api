package med.voll.api.doctors;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.DataAddress;

public record UpdateDataDoctor(@NotNull Long id, String name, String telefone, String email, DataAddress endereco) {
}
