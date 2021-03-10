package com.example.sfgpetclinic.bootstrap;

import com.example.sfgpetclinic.map.OwnerServiceMap;
import com.example.sfgpetclinic.map.VetServiceMap;
import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.service.OwnerService;
import com.example.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;

public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    public DataLoader() {
     ownerService=new OwnerServiceMap();
     vetService=new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Nyein");
        owner1.setLastName("Yadanar Tun");
ownerService.save(owner1);
        Owner owner2=new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Nyi Nyi");
        owner1.setLastName("Htun");
        ownerService.save(owner2);
        System.out.println("Load Owners...");
        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Pi");
        vet1.setLastName("Pi");
vetService.save(vet1);
Vet vet2=new Vet();
vet2.setId(2L);
vet2.setFirstName("Lone");
vet2.setLastName("Lone");
vetService.save(vet2);
        System.out.println("Load Vets...");
    }
}
