package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctors.ListDoctors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<ListDoctors> ListDoctors(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        return repository.findAll(pagination).map(ListDoctors::new);
    }

}
