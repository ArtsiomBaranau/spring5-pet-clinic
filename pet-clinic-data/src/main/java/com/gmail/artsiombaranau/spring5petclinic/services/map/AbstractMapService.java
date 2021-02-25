package com.gmail.artsiombaranau.spring5petclinic.services.map;

import com.gmail.artsiombaranau.spring5petclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    protected Long getNextId(){
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet())+1;
        } catch (NoSuchElementException ex){
            nextId=1L;
        }
        return nextId;
    }

}
