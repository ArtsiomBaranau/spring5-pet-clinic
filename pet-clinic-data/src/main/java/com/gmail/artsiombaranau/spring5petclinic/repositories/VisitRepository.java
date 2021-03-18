package com.gmail.artsiombaranau.spring5petclinic.repositories;

import com.gmail.artsiombaranau.spring5petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
