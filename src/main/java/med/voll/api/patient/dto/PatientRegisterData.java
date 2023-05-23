package med.voll.api.patient.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import med.voll.api.direccion.DirectionData;
import med.voll.api.doctor.model.Specialty;

public record PatientRegisterData(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String phone,
        @NotBlank
        String identityDocument,
        @NotBlank @Valid
        DirectionData direction
) {
}
