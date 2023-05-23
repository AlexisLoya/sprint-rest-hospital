package med.voll.api.patient.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DirectionData;

public record PatientUpdateData(
        String name,
        String phone,
        @NotNull String document,
        DirectionData direction) {

}
