package com.gmail.artsiombaranau.spring5petclinic.services.map;

import java.util.HashMap;
import java.util.Map;

public class AbstractMapService<T, ID> {
    protected Map<ID, T> map = new HashMap<>();

}
