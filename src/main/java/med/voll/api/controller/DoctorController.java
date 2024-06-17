package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctors.ListDoctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import med.voll.api.doctors.Doctor;
import med.voll.api.doctors.DoctorRegisterData;
import med.voll.api.doctors.DoctorRepository;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DoctorRegisterData data) {

        repository.save(new Doctor(data));

    }

    @GetMapping
    public List<ListDoctors> ListDoctors(){
        return repository.findAll().stream().map(ListDoctors::new).toList();
    }

}
