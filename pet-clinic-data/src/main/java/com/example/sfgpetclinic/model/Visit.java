package com.example.sfgpetclinic.model;

import sun.util.resources.LocaleData;

public class Visit extends BaseEntity{
    private LocaleData date;
    private String description;
    private Pet pet;

    public LocaleData getDate() {
        return date;
    }

    public void setDate(LocaleData date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
