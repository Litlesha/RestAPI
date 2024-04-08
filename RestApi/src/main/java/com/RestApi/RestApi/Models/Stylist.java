package com.RestApi.RestApi.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "stylist")
public class Stylist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "stylist", cascade = CascadeType.ALL)
    private Set<Client> clients;

    public Stylist(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Stylist() {

    }

}

