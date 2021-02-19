package com.gmail.artsiombaranau.spring5petclinic.services.map;

import com.gmail.artsiombaranau.spring5petclinic.model.BaseEntity;
import com.gmail.artsiombaranau.spring5petclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AbstractMapService<T extends BaseEntity, ID> implements CrudService<T, ID> {
    protected Map<ID, T> map = new HashMap<>();


    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T object) {
        return map.put((ID) object.getId(), object);
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    @Override
    public void deleteById(ID id) {
        map.remove(id);
    }
}
