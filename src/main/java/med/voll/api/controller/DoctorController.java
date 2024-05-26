package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.doctors.Doctor;
import med.voll.api.doctors.DoctorRegisterData;
import med.voll.api.doctors.DoctorRepository;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    public void register(@RequestBody DoctorRegisterData data) {

        repository.save(new Doctor(data));

    }

}
