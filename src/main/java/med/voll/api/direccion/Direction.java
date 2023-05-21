package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direction {
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;

    public Direction(DirectionData direction) {
        this.street = direction.street();
        this.number = direction.number();
        this.complement = direction.complement();
        this.city = direction.city();
        this.state = direction.state();
    }
}
