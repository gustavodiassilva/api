package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Address(DataAddress address) {
        this.logradouro = address.logradouro();
        this.bairro = address.bairro();
        this.cep = address.cep();
        this.cidade = address.cidade();
        this.complemento = address.complemento();
        this.cidade = address.cidade();
        this.uf = address.uf();
        this.numero = address.numero();
    }


    public void updateData(DataAddress data) {
        Map<String, Consumer<String>> setters = new HashMap<>();
        setters.put(data.logradouro(), this::setLogradouro);
        setters.put(data.bairro(), this::setBairro);
        setters.put(data.cep(), this::setCep);
        setters.put(data.numero(), this::setNumero);
        setters.put(data.complemento(), this::setComplemento);
        setters.put(data.cidade(), this::setCidade);
        setters.put(data.uf(), this::setUf);

        setters.forEach((value, setter) -> {
            if (value != null) {
                setter.accept(value);
            }
        });


    }
}
