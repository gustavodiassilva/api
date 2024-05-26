package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
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

}
