package com.Donation.Project.services;

import com.Donation.Project.entities.DonationDriveEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface DonationDriveService {
   DonationDriveEntity newDonationDrive(DonationDriveEntity donationDriveEntity, MultipartFile imageFile);

   List<DonationDriveEntity> getAllDonationDrives();


   DonationDriveEntity getProductById(Long driveID);

   void addImageToDonationDrive(Long id, byte[] image);

   DonationDriveEntity getDriveById(Long driveId);

   void addMoneyToDrive(Long driveId, Long amount);

}
