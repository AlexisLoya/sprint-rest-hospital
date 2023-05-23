package med.voll.api.doctor.dto;

import med.voll.api.doctor.model.Doctor;

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
