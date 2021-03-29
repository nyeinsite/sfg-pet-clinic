package com.example.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="pets")
public class Pet extends BaseEntity{
    @Builder
    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, List<Visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        if(visits==null || visits.size()>0) {
            this.visits = visits;
        }
    }

    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;
    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private List<Visit> visits=new ArrayList<>();



}
