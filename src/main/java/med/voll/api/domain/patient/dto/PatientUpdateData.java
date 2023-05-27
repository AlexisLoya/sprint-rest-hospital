package med.voll.api.domain.patient.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DirectionData;

public record PatientUpdateData(
        String name,
        String phone,
        @NotNull String document,
        DirectionData direction) {

}
