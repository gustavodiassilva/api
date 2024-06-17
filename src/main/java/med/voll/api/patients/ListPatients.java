package med.voll.api.patients;

public record ListPatients(String Name, String email, String telefone) {

    public ListPatients(Patient patients){
        this(patients.getName(), patients.getEmail(), patients.getTelefone());
    }
}
