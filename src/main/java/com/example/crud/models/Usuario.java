package com.example.crud.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    @JsonIgnore

    private Long id;

    @Column(name = "full_name")
    private String fullName;
 
    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "phone_extension")
    private Integer phoneExtension;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPhoneExtension() {
        return phoneExtension;
    }

    public void setPhoneExtension(Integer phoneExtension) {
        this.phoneExtension = phoneExtension;
    }
}