package com.example.sfgpetclinic.service;

import com.example.sfgpetclinic.model.Owner;



public interface OwnerService extends CrudService{
    Owner findByLastName(String lastName);

}