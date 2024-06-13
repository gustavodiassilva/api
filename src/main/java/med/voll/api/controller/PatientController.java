package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patients.Patient;
import med.voll.api.patients.PatientRegisterData;
import med.voll.api.patients.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

}