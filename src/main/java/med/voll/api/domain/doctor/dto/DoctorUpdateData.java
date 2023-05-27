package med.voll.api.domain.doctor.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DirectionData;

public record DoctorUpdateData(
        String name,
        String phone,
        @NotNull String document,
        DirectionData direction) {
}
