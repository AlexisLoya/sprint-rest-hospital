package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.doctor.dto.DoctorMedicList;
import med.voll.api.domain.doctor.model.Doctor;
import med.voll.api.domain.doctor.DoctorRepository;
import med.voll.api.domain.doctor.dto.DoctorDataRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;
    @PostMapping
    public ResponseEntity<DoctorDataRegister> registrar(@RequestBody @Valid DoctorDataRegister data, UriComponentsBuilder uriBuilder) {
        System.out.println("datos recebidos: " +data);
        Doctor doctor = repository.save(new Doctor(data));
        URI uri = uriBuilder.path("/doctor/{document}").buildAndExpand(doctor.getDocument()).toUri();
        return ResponseEntity.created(uri).body(doctor.toRegisterDto());

    }
    @GetMapping
    public ResponseEntity<Page<DoctorMedicList>> getAllDoctors(@PageableDefault(size = 10, sort = "name") Pageable pageable) {
        return ResponseEntity.ok(repository.findAllByActiveTrue(pageable).map(DoctorMedicList::new));
    }
    @GetMapping("/{document}")
    public ResponseEntity<DoctorDataRegister> getOneDoctor(@PathVariable String document) {
        Doctor doctor = repository.findByDocument(document).orElseThrow();
        return ResponseEntity.ok(doctor.toRegisterDto());
    }

    @PutMapping("/{document}")
    @Transactional
    public ResponseEntity<DoctorDataRegister> update(@PathVariable String document, @RequestBody @Valid DoctorDataRegister data) {
        Doctor doctor = repository.findByDocument(document).orElseThrow();
        doctor.updateData(data);
        repository.save(doctor);
        return ResponseEntity.ok(doctor.toRegisterDto());

    }
    @DeleteMapping("/{document}")
    @Transactional
    public ResponseEntity delete(@PathVariable String document) {
        Doctor doctor = repository.findByDocument(document).orElseThrow();
        doctor.delete();
        return ResponseEntity.noContent().build();
    }
}
