package med.voll.api.doctor.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DirectionData;

public record DoctorUpdateData(
        String name,
        String phone,
        @NotNull String document,
        DirectionData direction) {
}
