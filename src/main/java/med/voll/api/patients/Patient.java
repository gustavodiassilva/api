package med.voll.api.patients;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.address.Address;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


@Entity(name="Patient")
@Table(name="patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String telefone;

    @Embedded
    private Address address;

    private Boolean status;

    public Patient(PatientRegisterData data){
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.telefone = data.telefone();
        this.address = new Address(data.address());
        this.status = true;
    }


    public void updatePatients(UpdatePatient data) {
        Map<String, Consumer<String>> setters = new HashMap<>();
        setters.put(data.email(), this::setEmail);
        setters.put(data.telefone(), this::setTelefone);
        setters.put(data.name(), this::setName);

        if(data.endereco() != null){
            this.address.updateData(data.endereco());
        }

        setters.forEach((value, setter) -> {
            if(value != null){
                setter.accept(value);
            }
        });


    }

    public void deletePatients(Long id) {
        if(id != null){
            this.status = false;
        }
    }
}
