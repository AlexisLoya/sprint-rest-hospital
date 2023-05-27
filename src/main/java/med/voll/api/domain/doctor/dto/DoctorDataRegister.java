package med.voll.api.domain.doctor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DirectionData;
import med.voll.api.domain.doctor.model.Specialty;

public record DoctorDataRegister(
        @NotBlank
        String name,
        @Email
        @NotBlank

        String email,
        @NotBlank
        String phone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String document,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        DirectionData direction
        ) {
}