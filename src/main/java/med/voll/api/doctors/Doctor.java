package med.voll.api.doctors;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import med.voll.api.address.Address;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Address address;

    private Boolean status;


    public Doctor(DoctorRegisterData data) {
        this.name = data.name();
        this.crm = data.crm();
        this.email = data.email();
        this.telefone = data.telefone();
        this.address = new Address(data.address());
        this.especialidade = data.especialidade();
        this.status = true;
    }

    public void updateData(UpdateDataDoctor data) {
        Map<String, Consumer<String>> setters = new HashMap<>();
        setters.put(data.name(), this::setName);
        setters.put(data.email(), this::setEmail);
        setters.put(data.telefone(), this::setTelefone);

        if(data.endereco() != null) {
            this.address.updateData(data.endereco());
        }

        setters.forEach((value, setter) -> {
            if (value != null) {
                setter.accept(value);
            }
        });
    }

    public void DeleteDoctor(Long id){
        if(id != null){
            this.status = false;
        }
    }
}
