package med.voll.api.patients;

public record ListPatients(Long id, String Name, String email, String telefone) {

    public ListPatients(Patient patients){
        this(patients.getId(), patients.getName(), patients.getEmail(), patients.getTelefone());
    }
}
