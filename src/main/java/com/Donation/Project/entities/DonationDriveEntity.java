package com.Donation.Project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class DonationDriveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String status="pending";
    private Long amountCollected=0L;
    @Lob
    private byte[] image;
    private String  imageName;
    private String  imageType;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonBackReference("admin-drives")
    private AdminEntity admin;



    @ManyToOne
    @JoinColumn(name = "donor_id")
    @JsonBackReference("donor-drives")
    private DonorEntity donor;
}
