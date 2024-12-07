package com.Donation.Project.repositories;

import com.Donation.Project.entities.DonationDriveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationDrivesRepository extends JpaRepository<DonationDriveEntity,Long> {
}
