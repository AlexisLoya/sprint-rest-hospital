package med.voll.api.doctor;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direction;
import med.voll.api.doctor.dto.DoctorDataRegister;
import med.voll.api.doctor.model.Specialty;
@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String document;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Direction direction;

    public Doctor(DoctorDataRegister data) {
        this.name = data.name();
        this.email = data.email();
        this.document = data.document();
        this.specialty = data.specialty();
        this.direction = new Direction(data.direction());
    }
}
