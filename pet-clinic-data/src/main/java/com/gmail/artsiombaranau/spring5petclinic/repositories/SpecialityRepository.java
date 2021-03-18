package com.gmail.artsiombaranau.spring5petclinic.repositories;

import com.gmail.artsiombaranau.spring5petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
