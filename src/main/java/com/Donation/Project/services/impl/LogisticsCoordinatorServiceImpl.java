package com.Donation.Project.services.impl;

import com.Donation.Project.entities.LogisticsCoordinatorEntity;
import com.Donation.Project.repositories.LogisticsCoordinatorRepository;
import com.Donation.Project.services.LogisticsCoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogisticsCoordinatorServiceImpl implements LogisticsCoordinatorService {
    private final LogisticsCoordinatorRepository logisticsCoordinatorRepository;

    @Override
    public LogisticsCoordinatorEntity createCoordinator(LogisticsCoordinatorEntity logisticsCoordinatorEntity) {
        return logisticsCoordinatorRepository.save(logisticsCoordinatorEntity);
    }

    @Override
    public List<LogisticsCoordinatorEntity> getAllCoordinators() {
        return logisticsCoordinatorRepository.findAll();
    }
}
