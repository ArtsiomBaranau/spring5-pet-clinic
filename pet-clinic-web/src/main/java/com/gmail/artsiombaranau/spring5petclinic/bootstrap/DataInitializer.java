package com.gmail.artsiombaranau.spring5petclinic.bootstrap;

import com.gmail.artsiombaranau.spring5petclinic.model.Owner;
import com.gmail.artsiombaranau.spring5petclinic.model.Pet;
import com.gmail.artsiombaranau.spring5petclinic.model.PetType;
import com.gmail.artsiombaranau.spring5petclinic.model.Vet;
import com.gmail.artsiombaranau.spring5petclinic.services.OwnerService;
import com.gmail.artsiombaranau.spring5petclinic.services.PetTypeService;
import com.gmail.artsiombaranau.spring5petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types...");

        Owner owner1 = new Owner();
        owner1.setFirstName("James");
        owner1.setLastName("Dean");
        owner1.setTelephone("123456789");
        owner1.setAddress("Checherskaya street, 37");
        owner1.setCity("Gomel");

        Pet jamesPet = new Pet();
        jamesPet.setName("Scooby");
        jamesPet.setPetType(savedDogPetType);
        jamesPet.setOwner(owner1);
        jamesPet.setBirthDate(LocalDate.now());

        owner1.getPets().add(jamesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Skylar");
        owner2.setLastName("Grey");
        owner2.setTelephone("987654321");
        owner2.setAddress("Makayonka street, 12");
        owner2.setCity("Gomel");

        Pet skylarsPet = new Pet();
        skylarsPet.setName("Fiona");
        skylarsPet.setPetType(savedCatPetType);
        skylarsPet.setOwner(owner2);
        skylarsPet.setBirthDate(LocalDate.now());

        owner2.getPets().add(skylarsPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Tom");
        vet1.setLastName("Ford");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kali");
        vet2.setLastName("Roses");
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
