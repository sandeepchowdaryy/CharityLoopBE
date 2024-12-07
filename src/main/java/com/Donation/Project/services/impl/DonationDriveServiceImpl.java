package com.Donation.Project.services.impl;

import com.Donation.Project.entities.DonationDriveEntity;
import com.Donation.Project.repositories.DonationDrivesRepository;
import com.Donation.Project.services.DonationDriveService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationDriveServiceImpl implements DonationDriveService {

    private final DonationDrivesRepository donationDrivesRepository;

    @Override
    public DonationDriveEntity newDonationDrive(DonationDriveEntity donationDriveEntity, MultipartFile imageFile) {
        if (donationDriveEntity == null || imageFile == null) {
            throw new IllegalArgumentException("DonationDriveEntity or ImageFile cannot be null");
        }

        try {
            donationDriveEntity.setImageName(imageFile.getOriginalFilename());
            donationDriveEntity.setImageType(imageFile.getContentType());
            donationDriveEntity.setImage(imageFile.getBytes());

            return donationDrivesRepository.save(donationDriveEntity);
        } catch (IOException e) {
            throw new RuntimeException("Error processing image file: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error saving donation drive: " + e.getMessage(), e);
        }
    }




    @Override
    public List<DonationDriveEntity> getAllDonationDrives() {
        return donationDrivesRepository.findAll();
    }

    @Override
    public DonationDriveEntity getProductById(Long productId) {
        return donationDrivesRepository.findById(productId).orElse(null);
    }

    @Override
    public void addImageToDonationDrive(Long id, byte[] image) {
        DonationDriveEntity donationDrive = donationDrivesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donation Drive not found"));
        donationDrive.setImage(image);
        donationDrivesRepository.save(donationDrive);
    }

    @Override
    public DonationDriveEntity getDriveById(Long driveId) {
        return donationDrivesRepository.findById(driveId)
                .orElseThrow(() -> new EntityNotFoundException("Donation drive not found with ID: " + driveId));
    }

    @Override
    public void addMoneyToDrive(Long driveId, Long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        DonationDriveEntity donationDrive = donationDrivesRepository.findById(driveId)
                .orElseThrow(() -> new EntityNotFoundException("Donation drive not found with ID: " + driveId));

        if (donationDrive.getAmountCollected() == null) {
            donationDrive.setAmountCollected(0L);
        }

        donationDrive.setAmountCollected(donationDrive.getAmountCollected() + amount);

        donationDrivesRepository.save(donationDrive);
    }

}

