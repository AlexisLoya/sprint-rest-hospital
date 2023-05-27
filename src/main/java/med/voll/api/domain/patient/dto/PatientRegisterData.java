package med.voll.api.domain.patient.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import med.voll.api.domain.direccion.DirectionData;

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
