package com.gmail.artsiombaranau.spring5petclinic.services;

import com.gmail.artsiombaranau.spring5petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
