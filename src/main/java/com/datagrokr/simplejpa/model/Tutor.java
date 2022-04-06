package com.datagrokr.simplejpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue(value = "TR")
public class Tutor extends Person {

    public Tutor(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
