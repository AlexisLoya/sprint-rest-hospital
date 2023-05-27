package med.voll.api.doctor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DirectionData;
import med.voll.api.doctor.model.Specialty;
import org.hibernate.validator.constraints.UniqueElements;

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
