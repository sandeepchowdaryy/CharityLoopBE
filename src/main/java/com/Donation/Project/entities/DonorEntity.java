package com.Donation.Project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@ToString
public class DonorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    private String phone;
    private String role;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    @JsonManagedReference("donor-items")
    private List<DonationItemEntity> donations;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonBackReference("admin-donors")
    private AdminEntity admin;

    @OneToMany(mappedBy = "donor", cascade = CascadeType.ALL)
    @JsonManagedReference("donor-drives")
    private List<DonationDriveEntity> donationDrives;
}
