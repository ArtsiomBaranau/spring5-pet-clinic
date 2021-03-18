package com.gmail.artsiombaranau.spring5petclinic.repositories;

import com.gmail.artsiombaranau.spring5petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
