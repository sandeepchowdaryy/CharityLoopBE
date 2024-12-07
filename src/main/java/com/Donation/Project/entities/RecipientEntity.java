package com.Donation.Project.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private String phone;
    private String status;
    private String role;

    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL)
    @JsonManagedReference("recipient-items")
    private List<DonationItemEntity> requestedItems;

}
