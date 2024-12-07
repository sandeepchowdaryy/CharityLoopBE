package com.Donation.Project.repositories;

import com.Donation.Project.entities.LogisticsCoordinatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogisticsCoordinatorRepository extends JpaRepository<LogisticsCoordinatorEntity,Long> {

}
