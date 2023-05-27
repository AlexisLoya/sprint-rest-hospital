package med.voll.api.domain.doctor.dto;

import med.voll.api.domain.doctor.model.Doctor;

public record DoctorMedicList(
        String name,
        String specialty,
        String document,
        String email
) {
    public DoctorMedicList (Doctor doctor) {
        this(doctor.getName(), doctor.getSpecialty().name(), doctor.getDocument(), doctor.getEmail());
    }
}
