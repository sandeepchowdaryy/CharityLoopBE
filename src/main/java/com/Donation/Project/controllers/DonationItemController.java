package com.Donation.Project.controllers;

import com.Donation.Project.entities.DonationItemEntity;
import com.Donation.Project.entities.DonorEntity;
import com.Donation.Project.services.DonationItemService;
import com.Donation.Project.services.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/donationitem")
@CrossOrigin
public class DonationItemController {

    private final DonationItemService donationItemService;
    private final DonorService donorService;

    // Create a donation item
    @PostMapping
    public ResponseEntity<?> createDonationItem(@RequestPart("donationItemEntity") DonationItemEntity donationItemEntity,
                                                @RequestParam("donorId") Long donorId, @RequestPart("image") MultipartFile Image) {
        try {
            DonorEntity donor = donorService.getDonorByID(donorId);
            donationItemEntity.setDonor(donor);
            DonationItemEntity createdItem = donationItemService.createNewItem(donationItemEntity,Image);
            return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Get all donation items
    @GetMapping
    public ResponseEntity<List<DonationItemEntity>> getAllDonationItems() {
        List<DonationItemEntity> items = donationItemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
