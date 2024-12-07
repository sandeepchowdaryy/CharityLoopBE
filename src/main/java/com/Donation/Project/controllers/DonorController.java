package com.Donation.Project.controllers;

import com.Donation.Project.entities.DonationItemEntity;
import com.Donation.Project.entities.DonorEntity;
import com.Donation.Project.services.DonationItemService;
import com.Donation.Project.services.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/donor")
@CrossOrigin(origins = "http://localhost:3000")
public class DonorController {

    private final DonorService donorService;
   // private final DonationItemService donationItemService;

    @PostMapping
    public ResponseEntity<DonorEntity> createDonor(@RequestBody DonorEntity donorEntity) {
        DonorEntity createdDonor = donorService.createDonor(donorEntity);
        return new ResponseEntity<>(createdDonor, HttpStatus.CREATED);
    }

//    @PostMapping("/{donorId}/donationitem")
//    public ResponseEntity<DonationItemEntity> createDonationItem(
//            @PathVariable Long donorId,
//            @RequestBody DonationItemEntity donationItemEntity) {
//        try {
//            DonationItemEntity createdItem = donationItemService.createDonationItemForDonor(donorId, donationItemEntity);
//            System.out.println(createdItem);
//            return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping
    public ResponseEntity<?> getAllDonors() {
        try {
            List<DonorEntity> donors = donorService.getAllDonors();
            return new ResponseEntity<>(donors, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error fetching donors: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
