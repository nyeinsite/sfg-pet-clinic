package com.example.sfgpetclinic.bootstrap;


import com.example.sfgpetclinic.model.*;
import com.example.sfgpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
@Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
     this.ownerService=ownerService;
     this.vetService=vetService;
     this.petTypeService = petTypeService;
    this.specialityService = specialityService;
    this.visitService = visitService;
}

    @Override
    public void run(String... args) throws Exception {

    int count=petTypeService.findAll().size();
    if(count==0){
        loadData();
    }

    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogType =petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType savedCatType=petTypeService.save(cat);

        Speciality radiology=new Speciality();
        radiology.setDescripition("Radiology");
        Speciality savedRadiology=specialityService.save(radiology);
        Speciality surgery=new Speciality();
        radiology.setDescripition("Surgery");
        Speciality savedSurgery=specialityService.save(radiology);
        Speciality dentistry=new Speciality();
        radiology.setDescripition("Dentistry");
        Speciality savedDentistry=specialityService.save(radiology);
        Owner owner1=new Owner();
        //owner1.setId(1L);
        owner1.setFirstName("Nyein");
        owner1.setLastName("Yadanar Tun");
        owner1.setAddress("Yangon");
        owner1.setCity("Yangon");

        Pet nyeinPet=new Pet();
        nyeinPet.setPetType(savedDogType);
        nyeinPet.setOwner(owner1);
        nyeinPet.setBirthDate(LocalDate.now());
        nyeinPet.setName("Pi Pi");
        owner1.getPets().add(nyeinPet);
        ownerService.save(owner1);
        Owner owner2=new Owner();
        //  owner2.setId(2L);
        owner2.setFirstName("Nyi Nyi");
        owner2.setLastName("Htun");
        owner2.setAddress("Ba Yint Naung");
        owner2.setCity("Yangon");

        Pet nyiCat=new Pet();
        nyiCat.setName("Puci");
        nyiCat.setOwner(owner2);
        nyiCat.setBirthDate(LocalDate.now());
        nyiCat.setPetType(savedCatType);
        owner2.getPets().add(nyiCat);
        ownerService.save(owner2);

        Visit catVisit=new Visit();
        catVisit.setPet(nyiCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        System.out.println("Load Owners...");
        Vet vet1=new Vet();
        // vet1.setId(1L);
        vet1.setFirstName("Pi");
        vet1.setLastName("Pi");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);
        Vet vet2=new Vet();
//vet2.setId(2L);
        vet2.setFirstName("Lone");
        vet2.setLastName("Lone");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Load Vets...");
    }
}
