package com.Donation.Project.repositories;

import com.Donation.Project.entities.DonationItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationItemRepository extends JpaRepository<DonationItemEntity,Long> {
}
