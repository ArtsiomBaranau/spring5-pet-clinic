package com.gmail.artsiombaranau.spring5petclinic.services.map;

import com.gmail.artsiombaranau.spring5petclinic.model.Owner;
import com.gmail.artsiombaranau.spring5petclinic.services.OwnerService;

import java.util.HashSet;
import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public Owner findById(Long id) {
        return map.get(id);
    }

    @Override
    public Owner save(Owner object) {
        return map.put(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
