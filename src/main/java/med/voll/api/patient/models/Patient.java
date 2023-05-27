package med.voll.api.patient.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direction;
import med.voll.api.patient.dto.PatientRegisterData;
import med.voll.api.patient.dto.PatientUpdateData;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Patient")
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String identityDocument;
    private String phone;
    private Boolean active = true;

    @Embedded
    private Direction direction;

    public Patient(PatientRegisterData data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.identityDocument = data.identityDocument();
        this.direction = new Direction(data.direction());
    }
    public void update(PatientUpdateData data) {
        if (data.name() != null)
            this.name = data.name();

        if (data.phone() != null)
            this.phone = data.phone();

        if (data.direction() != null)
            this.direction = new Direction(data.direction());
    }

    public void delete() {
        this.active = false;
    }

    public PatientRegisterData toRegisterDto() {
        return new PatientRegisterData(
                this.name,
                this.email,
                this.phone,
                this.identityDocument,
                this.direction.toDto()
        );
    }
}
