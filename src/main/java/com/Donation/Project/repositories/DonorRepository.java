package com.Donation.Project.repositories;

import com.Donation.Project.entities.DonorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<DonorEntity,Long> {

}