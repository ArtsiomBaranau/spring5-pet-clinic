package com.gmail.artsiombaranau.spring5petclinic.services;

import com.gmail.artsiombaranau.spring5petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
