package com.example.relationships.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    private String addressId;
    private String city;
    private String zipCode;

    /** One to One Mapping
    @OneToOne(mappedBy = "primaryAddress")
    private Account account;
    **/

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

//    @ManyToMany(mappedBy = "sharedAddresses")
//    private List<Account> accounts = new ArrayList<>();
}
