package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patients.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;


    @PostMapping
    @Transactional
    public void createPatient(@RequestBody @Valid PatientRegisterData data){
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<ListPatients> ListPatients(Pageable pagination){
        return repository.findAll(pagination).map(ListPatients::new);
    }

    @PutMapping
    @Transactional
    public void UpdatePatients(@RequestBody @Valid UpdatePatient data){
        var patient = repository.getReferenceById(data.id());
        patient.updatePatients(data);
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public void DeletePatients(@PathVariable Long id){
        var patient = repository.getReferenceById(id);
        patient.deletePatients(id);
    }

}
