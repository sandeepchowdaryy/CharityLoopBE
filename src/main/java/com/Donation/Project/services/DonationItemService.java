package com.Donation.Project.services;

import com.Donation.Project.entities.DonationItemEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DonationItemService {
    DonationItemEntity createNewItem(DonationItemEntity donationItemEntity, MultipartFile image);
    List<DonationItemEntity> getAllItems();
//
//    DonationItemEntity createDonationItemForDonor(Long donorId, DonationItemEntity donationItemEntity);
//
//    DonationItemEntity getAllItemsById(Long id);
//
//
//    void deleteDonationItem(Long id);
//
//    DonationItemEntity updateDonationItem(Long id, DonationItemEntity donationItemEntity);
}
