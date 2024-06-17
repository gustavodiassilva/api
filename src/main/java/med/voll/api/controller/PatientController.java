package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patients.ListPatients;
import med.voll.api.patients.Patient;
import med.voll.api.patients.PatientRegisterData;
import med.voll.api.patients.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ListPatients> ListPatients(){
        return repository.findAll().stream().map(ListPatients::new).toList();
    }

}
