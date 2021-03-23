package com.gmail.artsiombaranau.spring5petclinic.services.map;

import com.gmail.artsiombaranau.spring5petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    final long ownerID = 1L;
    final String lastName = "Smith";
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerID).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerID);

        assertEquals(ownerID, owner.getId());
    }

    @Test
    void saveWithId() {
        Owner newOwner = Owner.builder().id(2L).build();
        Owner savedOwner = ownerServiceMap.save(newOwner);

        assertEquals(newOwner, savedOwner);
    }

    @Test
    void saveWithoutId() {
        Owner newOwner = Owner.builder().build();
        Owner savedOwner = ownerServiceMap.save(newOwner);

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerID));

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerID);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findByLastNameNotContain() {
        Owner owner = ownerServiceMap.findByLastName("Johns");

        assertNull(owner);
    }
}