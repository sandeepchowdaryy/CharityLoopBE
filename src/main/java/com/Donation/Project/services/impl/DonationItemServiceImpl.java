package com.Donation.Project.services.impl;

import com.Donation.Project.entities.DonationItemEntity;
import com.Donation.Project.entities.DonorEntity;
import com.Donation.Project.repositories.DonationItemRepository;
import com.Donation.Project.repositories.DonorRepository;
import com.Donation.Project.services.DonationItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DonationItemServiceImpl implements DonationItemService {
    private final DonationItemRepository donationItemRepository;
    //private final DonorRepository donorRepository;


    @Override
    public DonationItemEntity createNewItem(DonationItemEntity donationItemEntity, MultipartFile image) {
        if (donationItemEntity == null || image == null) {
            throw new IllegalArgumentException("DonationDriveEntity or ImageFile cannot be null");
        }
        try{
            donationItemEntity.setImageName(image.getOriginalFilename());
            donationItemEntity.setImageType(image.getContentType());
            donationItemEntity.setImage(image.getBytes());


            return donationItemRepository.save(donationItemEntity);
        } catch (IOException e) {
             throw new RuntimeException("Error processing image file: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Error saving donation drive: " + e.getMessage(), e);
        }
    }

    @Override
    public List<DonationItemEntity> getAllItems() {
        return donationItemRepository.findAll();
    }

//    @Override
//    public DonationItemEntity createDonationItemForDonor(Long donorId, DonationItemEntity donationItemEntity) {
//        DonorEntity donor = donorRepository.findById(donorId)
//                .orElseThrow(() -> new RuntimeException("Donor not found for ID: " + donorId));
//        donationItemEntity.setDonor(donor); // Associate the donor with the item
//        return donationItemRepository.save(donationItemEntity);
//    }

//    @Override
//    public DonationItemEntity getAllItemsById(Long id) {
//        Optional<DonationItemEntity> item = donationItemRepository.findById(id);
//        if (item.isPresent()) {
//            return item.get();
//        } else {
//            throw new RuntimeException("Donation item not found for ID: " + id);
//        }
//    }
//
//    @Override
//    public DonationItemEntity updateDonationItem(Long id, DonationItemEntity donationItemEntity) {
//        Optional<DonationItemEntity> existingItem = donationItemRepository.findById(id);
//        if (existingItem.isPresent()) {
//            DonationItemEntity itemToUpdate = existingItem.get();
//            itemToUpdate.setName(donationItemEntity.getName());
//            itemToUpdate.setQuantity(donationItemEntity.getQuantity());
//            itemToUpdate.setStatus(donationItemEntity.getStatus());
//            itemToUpdate.setDrive(donationItemEntity.getDrive());
//            itemToUpdate.setRecipient(donationItemEntity.getRecipient());
//            itemToUpdate.setCoordinator(donationItemEntity.getCoordinator());
//            return donationItemRepository.save(itemToUpdate);
//        } else {
//            throw new RuntimeException("Donation item not found for ID: " + id);
//        }
//    }
//
//    // Delete a donation item
//    @Override
//    public void deleteDonationItem(Long id) {
//        Optional<DonationItemEntity> item = donationItemRepository.findById(id);
//        if (item.isPresent()) {
//            donationItemRepository.deleteById(id);
//        } else {
//            throw new RuntimeException("Donation item not found for ID: " + id);
//        }
//    }
}
