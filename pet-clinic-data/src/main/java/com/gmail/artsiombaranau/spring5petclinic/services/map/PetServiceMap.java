package com.gmail.artsiombaranau.spring5petclinic.services.map;

import com.gmail.artsiombaranau.spring5petclinic.model.Pet;
import com.gmail.artsiombaranau.spring5petclinic.services.PetService;

import java.util.HashSet;
import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public Pet findById(Long id) {
        return map.get(id);
    }

    @Override
    public Pet save(Pet object) {
        return map.put(object.getId(), object);
    }

    @Override
    public void delete(Pet object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }
}
