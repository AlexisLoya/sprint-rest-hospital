package med.voll.api.doctor;

import med.voll.api.doctor.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByDocument(String document);
    void deleteByDocument(String document);
    Page<Doctor> findAllByActiveTrue(Pageable pageable);
}
