package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patient.dto.PatientRegisterData;
import med.voll.api.patient.PatientRepository;
import med.voll.api.patient.dto.PatientsList;
import med.voll.api.patient.dto.PatientUpdateData;
import med.voll.api.patient.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientRepository repository;
    @PostMapping
    public void registrar(@RequestBody@Valid PatientRegisterData data) {
        System.out.println("datos recebidos: " +data);
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientsList> listar(@PageableDefault(page = 0, size = 10, sort = {"nombre"}) Pageable paginacion) {
        return repository.findAll(paginacion).map(PatientsList::new);
    }

    @PutMapping("/{document}")
    @Transactional
    public void update(@PathVariable String document, @RequestBody @Valid PatientUpdateData data) {
        var patient = repository.findByIdentityDocument(document).orElseThrow();
        patient.update(data);
    }

    @DeleteMapping("/{document}")
    @Transactional
    public void remove(@PathVariable String document) {
        Patient patient = repository.findByIdentityDocument(document).orElseThrow();
        patient.delete();
    }
}
