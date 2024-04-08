package com.RestApi.RestApi.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Entity
@Getter
@Setter
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_stylist")
    private Stylist stylist;


    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Client() {

    }
}
