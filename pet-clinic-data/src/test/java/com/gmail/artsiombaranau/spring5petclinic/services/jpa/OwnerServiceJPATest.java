package com.gmail.artsiombaranau.spring5petclinic.services.jpa;

import com.gmail.artsiombaranau.spring5petclinic.model.Owner;
import com.gmail.artsiombaranau.spring5petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJPATest {

    final String lastName = "Smith";
    final long ownerID = 1L;
    Owner expectedOwner;

    @Mock
    OwnerRepository ownerRepository;
    @InjectMocks
    OwnerServiceJPA ownerServiceJPA;

    @BeforeEach
    void setUp() {
        expectedOwner = Owner.builder().id(ownerID).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(expectedOwner);

        Owner owner = ownerServiceJPA.findByLastName(lastName);

        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwners = new HashSet<>();
        returnedOwners.add(Owner.builder().id(1L).lastName("Rose").build());
        returnedOwners.add(Owner.builder().id(2L).lastName("Johns").build());

        when(ownerRepository.findAll()).thenReturn(returnedOwners);

        Set<Owner> owners = ownerServiceJPA.findAll();

        assertEquals(2, owners.size());
        assertIterableEquals(returnedOwners, owners);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(expectedOwner));

        Owner owner = ownerServiceJPA.findById(1L);

        assertEquals(1L, owner.getId());
    }

    @Test
    void findByIdIfNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerServiceJPA.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(expectedOwner);

        Owner owner = ownerServiceJPA.save(expectedOwner);

        assertEquals(expectedOwner, owner);
    }

    @Test
    void delete() {
        ownerServiceJPA.delete(expectedOwner);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerServiceJPA.deleteById(expectedOwner.getId());

        verify(ownerRepository, times(1)).deleteById(anyLong());
    }
}