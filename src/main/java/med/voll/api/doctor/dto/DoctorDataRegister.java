package med.voll.api.doctor.dto;

import med.voll.api.direccion.DirectionData;
import med.voll.api.doctor.model.Specialty;

public record DoctorDataRegister(
        String name,
        String email,
        String document,
        Specialty specialty,
        DirectionData direction
        ) {
}
