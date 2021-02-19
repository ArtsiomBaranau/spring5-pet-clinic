package com.gmail.artsiombaranau.spring5petclinic.services;

import com.gmail.artsiombaranau.spring5petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
