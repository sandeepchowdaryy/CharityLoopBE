package com.Donation.Project.controllers;

import com.Donation.Project.entities.DonationDriveEntity;
import com.Donation.Project.entities.DonorEntity;
import com.Donation.Project.services.DonationDriveService;
import com.Donation.Project.services.DonorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/donationdrive")
@CrossOrigin
public class DonationDriveController {

    private final DonationDriveService donationDriveService;
    private final DonorService donorService;


    @PostMapping
    public ResponseEntity<?> createDonationDrive(
            @RequestPart("donationDrive") DonationDriveEntity donationDriveEntity,
            @RequestPart("imageFile") MultipartFile image) {
        try {
            DonationDriveEntity donationDriveEntity1 = donationDriveService.newDonationDrive(donationDriveEntity, image);
            return new ResponseEntity<>(donationDriveEntity1, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Unexpected error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping()
    public ResponseEntity<List<DonationDriveEntity>> getAllDonationDrives() {
        try {
            List<DonationDriveEntity> donationDrives = donationDriveService.getAllDonationDrives();
            return new ResponseEntity<>(donationDrives, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{driveId}")
    public ResponseEntity<DonationDriveEntity> getDriveById(@PathVariable long driveId) {
        try {
            DonationDriveEntity donationDrives = donationDriveService.getDriveById(driveId);
            return new ResponseEntity<>(donationDrives, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/{driveID}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long driveID){
        DonationDriveEntity product = donationDriveService.getProductById(driveID);
        byte[] imageFile = product.getImage();

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }
    @PatchMapping("/{driveId}/{amount}")
    public ResponseEntity<?> addMoneyToDonationDrive(
            @PathVariable Long driveId,
            @PathVariable Long amount) {
        try {
            donationDriveService.addMoneyToDrive(driveId, amount);
            return new ResponseEntity<>("Money added successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Unexpected error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



//    @GetMapping("/{id}/image")
//    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
//        try {
//            byte[] image = donationDriveService.getDonationDriveImage(id);
//            return new ResponseEntity<>(image, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        }
//    }
}

