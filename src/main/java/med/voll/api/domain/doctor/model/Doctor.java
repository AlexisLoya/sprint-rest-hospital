package med.voll.api.domain.doctor.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direction;
import med.voll.api.domain.doctor.dto.DoctorDataRegister;

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
    private String phone;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Direction direction;

    private Boolean active;

    public Doctor(DoctorDataRegister data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.document = data.document();
        this.specialty = data.specialty();
        this.direction = new Direction(data.direction());
        this.active = true;
    }
    public void updateData(DoctorDataRegister data) {
        if (this.name != null){
            this.name = data.name();
        }
        if (this.direction != null){
            this.direction = new Direction(data.direction());
        }
    }
    public void delete() {
        this.active = false;
    }
    public DoctorDataRegister toRegisterDto() {
        return new DoctorDataRegister(
                this.name,
                this.email,
                this.phone,
                this.document,
                this.specialty,
                this.direction.toDto()
        );
    }

}
