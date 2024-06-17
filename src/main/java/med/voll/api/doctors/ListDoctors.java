package med.voll.api.doctors;

public record ListDoctors(String name, String email, String crm, Especialidade especialidade) {

    public ListDoctors(Doctor doctor){
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialidade());
    }
}
