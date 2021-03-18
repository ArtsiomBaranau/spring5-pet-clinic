package com.gmail.artsiombaranau.spring5petclinic.bootstrap;

import com.gmail.artsiombaranau.spring5petclinic.model.*;
import com.gmail.artsiombaranau.spring5petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded pet types...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Loaded specialties...");

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

        System.out.println("Loaded owners...");

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(skylarsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Two owners will be...");

        visitService.save(catVisit);

        System.out.println("Loaded visits...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Tom");
        vet1.setLastName("Ford");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Kali");
        vet2.setLastName("Roses");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
