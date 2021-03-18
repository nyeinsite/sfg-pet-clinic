package com.example.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "vets")
public class Vet extends Person{
private Set<Speciality> specialities=new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "vet_specialities",
joinColumns = @JoinColumn(name = "vet_id"),
inverseJoinColumns = @JoinColumn(name="speciality_id"))
    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
