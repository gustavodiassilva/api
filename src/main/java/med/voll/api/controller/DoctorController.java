package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.doctors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

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
        return repository.findAllByStatusTrue(pagination).map(ListDoctors::new);
    }

    @PutMapping
    @Transactional
    public void UpdateDoctors(@RequestBody @Valid UpdateDataDoctor data){
        var doctor = repository.getReferenceById(data.id());
        doctor.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void DeleteDoctors(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.DeleteDoctor(id);
    }

}
