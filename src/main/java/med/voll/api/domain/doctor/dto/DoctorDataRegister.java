package med.voll.api.domain.doctor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DirectionData;
import med.voll.api.domain.doctor.model.Specialty;

public record DoctorDataRegister(
        @NotBlank(message = "{name.mandatory}")
        String name,
        @Email(message = "{email.invalid}")
        @NotBlank(message = "{email.mandatory}")

        String email,
        @NotBlank(message = "{phone.mandatory}")
        String phone,
        @NotBlank(message = "{document.mandatory}")
        @Pattern(regexp = "\\d{4,6}", message = "{document.invalid}")
        String document,
        @NotNull(message = "{specialty.mandatory}")
        Specialty specialty,
        @NotNull(message = "{direction.mandatory}")
        @Valid
        DirectionData direction
        ) {
}
