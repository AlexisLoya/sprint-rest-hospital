package med.voll.api.domain.direccion;

import jakarta.validation.constraints.NotBlank;

public record DirectionData(
        @NotBlank
        String street,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank
        String number,
        @NotBlank
        String complement) {
}
