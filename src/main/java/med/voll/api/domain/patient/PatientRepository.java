package med.voll.api.domain.patient;

import med.voll.api.domain.patient.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
    Optional<Patient> findByIdentityDocument(String document);
}
