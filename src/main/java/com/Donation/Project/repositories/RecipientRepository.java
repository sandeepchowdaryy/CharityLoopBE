package com.Donation.Project.repositories;

import com.Donation.Project.entities.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<RecipientEntity,Long> {
}
