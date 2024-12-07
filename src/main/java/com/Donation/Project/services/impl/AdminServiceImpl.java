package com.Donation.Project.services.impl;

import com.Donation.Project.entities.*;
import com.Donation.Project.repositories.*;
import com.Donation.Project.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final DonationDrivesRepository donationDrivesRepository;
    private final DonationItemRepository donationItemRepository;
    private final DonorRepository donorRepository;
    private final RecipientRepository recipientRepository;
    private final LogisticsCoordinatorRepository logisticsCoordinatorRepository;

    @Override
    public List<DonationDriveEntity> getAllDonationDrives() {
        return donationDrivesRepository.findAll();
    }

    @Override
    public List<DonationItemEntity> getAllDonationItems() {
        return donationItemRepository.findAll();
    }

    @Override
    public List<DonorEntity> getAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public List<RecipientEntity> getAllRecipient() {
        return recipientRepository.findAll();
    }

    @Override
    public List<LogisticsCoordinatorEntity> getAllCoordinators() {
        return logisticsCoordinatorRepository.findAll();
    }

    @Override
    public AdminEntity createNewAdmin(AdminEntity adminEntity) {
        return adminRepository.save(adminEntity);
    }

    @Override
    public List<DonationDriveEntity> getDonationDrivesByAdmin(Long adminId) {
        AdminEntity admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found for ID: " + adminId));
        return admin.getManagedDrives();
    }

    @Override
    public List<DonorEntity> getDonorsByAdmin(Long adminId) {
        AdminEntity admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found for ID: " + adminId));
        return admin.getDonors();
    }

    @Override
    public void acceptDonationDrive(Long adminId, Long driveId) {
        AdminEntity admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found for ID: " + adminId));
        DonationDriveEntity drive = donationDrivesRepository.findById(driveId)
                .orElseThrow(() -> new RuntimeException("Donation drive not found for ID: " + driveId));

        admin.acceptDrive(drive);
        donationDrivesRepository.save(drive);
    }

    @Override
    public void rejectDonationDrive(Long adminId, Long driveId) {
        AdminEntity admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found for ID: " + adminId));
        DonationDriveEntity drive = donationDrivesRepository.findById(driveId)
                .orElseThrow(() -> new RuntimeException("Donation drive not found for ID: " + driveId));

        admin.rejectDrive(drive);
        donationDrivesRepository.save(drive);
    }

    @Override
    public void acceptLogisticsCoordinator(Long adminId, Long coordinatorId) {
        AdminEntity admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found for ID: " + adminId));
        LogisticsCoordinatorEntity coordinator = logisticsCoordinatorRepository.findById(coordinatorId)
                .orElseThrow(() -> new RuntimeException("Logistics Coordinator not found for ID: " + coordinatorId));

        admin.acceptLogisticsCoordinator(coordinator);
        coordinator.setStatus("accepted");
        logisticsCoordinatorRepository.save(coordinator);
    }

    @Override
    public void rejectLogisticsCoordinator(Long adminId, Long coordinatorId) {
        AdminEntity admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found for ID: " + adminId));
        LogisticsCoordinatorEntity coordinator = logisticsCoordinatorRepository.findById(coordinatorId)
                .orElseThrow(() -> new RuntimeException("Logistics Coordinator not found for ID: " + coordinatorId));

        admin.rejectLogisticsCoordinator(coordinator);
        coordinator.setStatus("rejected");
        logisticsCoordinatorRepository.save(coordinator);
    }

    @Override
    public void acceptRecipient(Long adminId, Long recipientId) {
        AdminEntity admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found for ID: " + adminId));
        RecipientEntity recipient = recipientRepository.findById(recipientId)
                .orElseThrow(() -> new RuntimeException("Recipient not found for ID: " + recipientId));

        admin.acceptRecipient(recipient);
        recipientRepository.save(recipient);
    }

    @Override
    public void rejectRecipient(Long adminId, Long recipientId) {
        AdminEntity admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found for ID: " + adminId));
        RecipientEntity recipient = recipientRepository.findById(recipientId)
                .orElseThrow(() -> new RuntimeException("Recipient not found for ID: " + recipientId));

        admin.rejectRecipient(recipient);
        recipientRepository.save(recipient);
    }

    @Override
    public List<AdminEntity> getAllAdmins() {
        return adminRepository.findAll();
    }

}
