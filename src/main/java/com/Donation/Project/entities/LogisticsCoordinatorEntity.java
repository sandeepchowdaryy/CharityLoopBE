package com.Donation.Project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class LogisticsCoordinatorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String role;
    private String password;

    private String status = "pending";

    @OneToMany(mappedBy = "coordinator", cascade = CascadeType.ALL)
    @JsonManagedReference("coordinator-items")
    private List<DonationItemEntity> managedItems;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonBackReference("admin-coordinators")
    private AdminEntity admin;
}
