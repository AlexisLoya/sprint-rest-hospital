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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientRepository repository;
    @PostMapping
    public ResponseEntity<PatientRegisterData> registrar(@RequestBody@Valid PatientRegisterData data, UriComponentsBuilder uriBuilder) {
        System.out.println("datos recebidos: " +data);
        Patient patient = repository.save(new Patient(data));
        URI uri = uriBuilder.path("/patient/{document}").buildAndExpand(patient.getIdentityDocument()).toUri();
        return ResponseEntity.created(uri).body(patient.toRegisterDto());
    }

    @GetMapping
    public ResponseEntity<Page<PatientsList>> listar(@PageableDefault(page = 0, size = 10, sort = {"nombre"}) Pageable paginacion) {
        return ResponseEntity.ok(repository.findAll(paginacion).map(PatientsList::new));
    }

    @GetMapping("/{document}")
    public ResponseEntity<PatientRegisterData> detallar(@PathVariable String document) {
        var paciente = repository.findByIdentityDocument(document).orElseThrow();
        return ResponseEntity.ok(paciente.toRegisterDto());
    }

    @PutMapping("/{document}")
    @Transactional
    public ResponseEntity<PatientRegisterData> update(@PathVariable String document, @RequestBody @Valid PatientUpdateData data) {
        var patient = repository.findByIdentityDocument(document).orElseThrow();
        patient.update(data);
        return ResponseEntity.ok(patient.toRegisterDto());
    }

    @DeleteMapping("/{document}")
    @Transactional
    public ResponseEntity<PatientRegisterData> remove(@PathVariable String document) {
        Patient patient = repository.findByIdentityDocument(document).orElseThrow();
        patient.delete();
        return ResponseEntity.noContent().build();
    }
}
