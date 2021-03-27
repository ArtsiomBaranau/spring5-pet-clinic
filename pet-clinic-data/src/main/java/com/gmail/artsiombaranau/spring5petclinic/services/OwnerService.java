package com.gmail.artsiombaranau.spring5petclinic.services;

import com.gmail.artsiombaranau.spring5petclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
