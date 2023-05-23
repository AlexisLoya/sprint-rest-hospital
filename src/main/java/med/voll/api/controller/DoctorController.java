package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.doctor.dto.DoctorMedicList;
import med.voll.api.doctor.model.Doctor;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.dto.DoctorDataRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;
    @PostMapping
    public void registrar(@RequestBody @Valid DoctorDataRegister data) {
        System.out.println("datos recebidos: " +data);
        repository.save(new Doctor(data));
    }
    @GetMapping
    public Page<DoctorMedicList> getAll(@PageableDefault(size = 10, sort = "name") Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(DoctorMedicList::new);
    }
    @PutMapping("/{document}")
    @Transactional
    public void update(@PathVariable String document, @RequestBody @Valid DoctorDataRegister data) {
        Doctor doctor = repository.findByDocument(document).orElseThrow();
        doctor.updateData(data);
        repository.save(doctor);
    }
    @DeleteMapping("/{document}")
    @Transactional
    public void delete(@PathVariable String document) {
        Doctor doctor = repository.findByDocument(document).orElseThrow();
        doctor.delete();
    }
}
