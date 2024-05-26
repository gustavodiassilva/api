package med.voll.api.doctors;

import med.voll.api.address.DataAddress;

public record DoctorRegisterData(String name, String email, String crm, Especialidade especialidade, DataAddress address) {

}
