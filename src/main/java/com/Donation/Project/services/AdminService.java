package com.Donation.Project.services;

import com.Donation.Project.entities.*;

import java.util.List;

public interface AdminService {
   List<DonationDriveEntity> getAllDonationDrives();
   List<DonationItemEntity> getAllDonationItems();
   List<DonorEntity> getAllDonors();
   List<RecipientEntity> getAllRecipient();
   List<LogisticsCoordinatorEntity> getAllCoordinators();

   AdminEntity createNewAdmin(AdminEntity adminEntity);

   List<DonationDriveEntity> getDonationDrivesByAdmin(Long adminId);

   List<DonorEntity> getDonorsByAdmin(Long adminId);

   void acceptDonationDrive(Long adminId, Long driveId);

   void rejectDonationDrive(Long adminId, Long driveId);

   void acceptLogisticsCoordinator(Long adminId, Long coordinatorId);

   void rejectLogisticsCoordinator(Long adminId, Long coordinatorId);

   void acceptRecipient(Long adminId, Long recipientId);

   void rejectRecipient(Long adminId, Long recipientId);


   List<AdminEntity> getAllAdmins();
}
