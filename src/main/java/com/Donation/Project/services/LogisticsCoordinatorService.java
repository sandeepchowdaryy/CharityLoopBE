package com.Donation.Project.services;

import com.Donation.Project.entities.LogisticsCoordinatorEntity;

import java.util.List;

public interface LogisticsCoordinatorService {
    LogisticsCoordinatorEntity createCoordinator(LogisticsCoordinatorEntity logisticsCoordinatorEntity);
    List<LogisticsCoordinatorEntity> getAllCoordinators();
}
