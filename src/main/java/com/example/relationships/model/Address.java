package com.example.relationships.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
