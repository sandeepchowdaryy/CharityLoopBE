package com.Donation.Project.services;

import com.Donation.Project.entities.RecipientEntity;

import java.util.List;

public interface RecipientService {
    RecipientEntity createNewRecipient(RecipientEntity recipientEntity);
    List<RecipientEntity> getAllRecipient();
    void acceptLogisticsCoordinator(Long adminId, Long coordinatorId);
    void rejectLogisticsCoordinator(Long adminId, Long coordinatorId);
}
