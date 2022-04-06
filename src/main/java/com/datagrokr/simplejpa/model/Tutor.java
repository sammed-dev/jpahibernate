package com.datagrokr.simplejpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
// @DiscriminatorValue(value = "TR")
// @PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Tutor extends Person {

    public Tutor(String firstName, String lastName) {
        super(firstName, lastName);
    }
}
