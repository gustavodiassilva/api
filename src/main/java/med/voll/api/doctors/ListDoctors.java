package med.voll.api.doctors;

public record ListDoctors(Long id, String name, String email, String crm, Especialidade especialidade) {

    public ListDoctors(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialidade());
    }
}
