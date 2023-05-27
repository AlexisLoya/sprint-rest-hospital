package med.voll.api.domain.patient.dto;

import med.voll.api.domain.patient.models.Patient;

public record PatientsList (
    String name,
    String email,
    String identityDocument

) {
    public PatientsList (Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getIdentityDocument());
    }
}
