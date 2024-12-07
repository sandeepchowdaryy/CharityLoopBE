package com.Donation.Project.services.impl;

import com.Donation.Project.entities.RecipientEntity;
import com.Donation.Project.repositories.RecipientRepository;
import com.Donation.Project.services.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipientServiceImpl implements RecipientService {

    private final RecipientRepository recipientRepository;
    @Override
    public RecipientEntity createNewRecipient(RecipientEntity recipientEntity) {
        return recipientRepository.save(recipientEntity);
    }

    @Override
    public List<RecipientEntity> getAllRecipient() {
        return recipientRepository.findAll();
    }

    @Override
    public void acceptLogisticsCoordinator(Long adminId, Long coordinatorId) {

    }

    @Override
    public void rejectLogisticsCoordinator(Long adminId, Long coordinatorId) {

    }
}
