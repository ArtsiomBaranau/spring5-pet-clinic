package com.gmail.artsiombaranau.spring5petclinic.repositories;

import com.gmail.artsiombaranau.spring5petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
