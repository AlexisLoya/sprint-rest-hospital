package med.voll.api.direccion;

public record DirectionData(
        String street,
        String city,
        String state,
        String number,
        String complement) {
}
