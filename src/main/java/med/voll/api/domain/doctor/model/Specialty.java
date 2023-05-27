package med.voll.api.domain.doctor.model;

public enum Specialty {
    CARDIOLOGIST("Cardiologista"),
    DERMATOLOGIST("Dermatologista"),
    ENDOCRINOLOGIST("Endocrinologista"),
    GASTROENTEROLOGIST("Gastroenterologista"),
    GYNECOLOGIST("Ginecologista"),
    HEMATOLOGIST("Hematologista"),
    NEPHROLOGIST("Nefrologista"),
    NEUROLOGIST("Neurologista"),
    OPHTHALMOLOGIST("Oftalmologista"),
    OTOLARYNGOLOGIST("Otorrinolaringologista"),
    PEDIATRICIAN("Pediatra"),
    PULMONOLOGIST("Pneumologista"),
    UROLOGIST("Urologista");

    private final String description;

    Specialty(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
