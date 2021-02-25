package com.gmail.artsiombaranau.spring5petclinic.bootstrap;

import com.gmail.artsiombaranau.spring5petclinic.model.Owner;
import com.gmail.artsiombaranau.spring5petclinic.model.Vet;
import com.gmail.artsiombaranau.spring5petclinic.services.OwnerService;
import com.gmail.artsiombaranau.spring5petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("James");
        owner1.setLastName("Dean");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Skylar");
        owner2.setLastName("Grey");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Tom");
        vet1.setLastName("Ford");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Kali");
        vet1.setLastName("Roses");
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
