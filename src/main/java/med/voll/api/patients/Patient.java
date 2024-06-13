package med.voll.api.patients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;


@Entity(name="Patient")
@Table(name="patients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String email;
    private String cpf;
    private String telefone;

    @Embedded
    private Address address;

    public Patient(PatientRegisterData data){
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.telefone = data.telefone();
        this.address = new Address(data.address());
    }


}
