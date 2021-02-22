package com.gmail.artsiombaranau.spring5petclinic.services.map;

import com.gmail.artsiombaranau.spring5petclinic.model.Vet;
import com.gmail.artsiombaranau.spring5petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public Vet findById(Long id) {
        return map.get(id);
    }

    @Override
    public Vet save(Vet object) {
        return map.put(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(Long id) {
        map.remove(id);
    }
}
