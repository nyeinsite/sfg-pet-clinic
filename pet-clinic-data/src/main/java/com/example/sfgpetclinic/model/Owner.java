package com.example.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person{
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pets=new HashSet<>();
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="telephone")
    private String telephone;
@Builder

    public Owner(Long id, String firstName, String lastName, Set<Pet> pets, String address, String city, String telephone) {
        super(id, firstName, lastName);
       if(pets!=null)
       {this.pets = pets;}
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public Pet getPet(String name){
    return getPet(name,false);
    }
    public Pet getPet(String name,boolean ignoreNew){
    name=name.toLowerCase(Locale.ROOT);
    for(Pet pet:pets){
        if(!ignoreNew || !pet.isNew()){
            String compName=pet.getName();
            compName=compName.toLowerCase(Locale.ROOT);
            if(compName.equals(name)){
                return pet;
            }
        }
    }
    return null;
    }
}
