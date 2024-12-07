package com.Donation.Project.entities;

import com.Donation.Project.enums.DonationStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DonationItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    private String dsc;

    private String status = "pending"; // Enum for statuses like PENDING, DELIVERED

    @Lob
    private byte[] image;
    private String imageName;
    private String imageType;

    @ManyToOne
    @JoinColumn(name = "donor_id", nullable = true)
    @JsonBackReference("donor-items")
    private DonorEntity donor ;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    @JsonBackReference("recipient-items")
    private RecipientEntity recipient;



    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    @JsonBackReference("coordinator-items")
    private LogisticsCoordinatorEntity coordinator;
}
