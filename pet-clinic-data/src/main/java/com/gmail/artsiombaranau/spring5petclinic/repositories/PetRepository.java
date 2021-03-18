package com.gmail.artsiombaranau.spring5petclinic.repositories;

import com.gmail.artsiombaranau.spring5petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
