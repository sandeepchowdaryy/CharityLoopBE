package com.Donation.Project.entities;

import com.Donation.Project.enums.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String phone;

    private String role;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonManagedReference("admin-donors")
    private List<DonorEntity> donors;

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonManagedReference("admin-drives")
    private List<DonationDriveEntity> managedDrives;

    public void acceptDrive(DonationDriveEntity drive) {
        drive.setStatus("accepted");
        drive.setAdmin(this);
    }

    public void rejectDrive(DonationDriveEntity drive) {
        drive.setStatus("rejected");
        drive.setAdmin(this);
    }

    public void acceptLogisticsCoordinator(LogisticsCoordinatorEntity coordinator) {
        coordinator.setAdmin(this);
    }

    public void rejectLogisticsCoordinator(LogisticsCoordinatorEntity coordinator) {
        coordinator.setAdmin(null);
    }

    public void acceptRecipient(RecipientEntity recipient) {
        recipient.setStatus("Accepted");
    }
    public void rejectRecipient(RecipientEntity recipient) {
        recipient.setStatus("Rejected");
    }
}

