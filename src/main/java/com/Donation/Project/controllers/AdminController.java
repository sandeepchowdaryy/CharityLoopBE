package com.Donation.Project.controllers;

import com.Donation.Project.entities.AdminEntity;
import com.Donation.Project.entities.DonationDriveEntity;
import com.Donation.Project.entities.DonorEntity;
import com.Donation.Project.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = "/admin")
public class AdminController {

    private final AdminService adminService;

    // Create a new admin
    @PostMapping
    public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity adminEntity) {
        try {
            AdminEntity createdAdmin = adminService.createNewAdmin(adminEntity);
            return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<AdminEntity>> getAllAdmin() {
        try {
            List<AdminEntity> donationDrives = adminService.getAllAdmins();
            return new ResponseEntity<>(donationDrives, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{adminId}/donationdrives")
    public ResponseEntity<List<DonationDriveEntity>> getDonationDrivesByAdmin(@PathVariable() Long adminId) {
        try {
            List<DonationDriveEntity> donationDrives = adminService.getDonationDrivesByAdmin(adminId);
            return new ResponseEntity<>(donationDrives, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{adminId}/donor")
    public ResponseEntity<List<DonorEntity>> getDonorsByAdmin(@PathVariable Long adminId) {
        try{
            List<DonorEntity> donorEntities = adminService.getDonorsByAdmin(adminId);
            return new ResponseEntity<>(donorEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{adminId}/donationdrives/{driveId}/accept")
    public ResponseEntity<String> acceptDonationDrive(@PathVariable Long adminId, @PathVariable Long driveId) {
        try {
            adminService.acceptDonationDrive(adminId, driveId);
            return new ResponseEntity<>("Donation drive accepted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Reject a donation drive
    @PutMapping("/{adminId}/donationdrives/{driveId}/reject")
    public ResponseEntity<String> rejectDonationDrive(@PathVariable Long adminId, @PathVariable Long driveId) {
        try {
            adminService.rejectDonationDrive(adminId, driveId);
            return new ResponseEntity<>("Donation drive rejected successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{adminId}/coordinators/{coordinatorId}/accept")
    public ResponseEntity<String> acceptLogisticsCoordinator(@PathVariable Long adminId, @PathVariable Long coordinatorId) {
        try {
            adminService.acceptLogisticsCoordinator(adminId, coordinatorId);
            return new ResponseEntity<>("Logistics Coordinator accepted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{adminId}/coordinators/{coordinatorId}/reject")
    public ResponseEntity<String> rejectLogisticsCoordinator(@PathVariable Long adminId, @PathVariable Long coordinatorId) {
        try {
            adminService.rejectLogisticsCoordinator(adminId, coordinatorId);
            return new ResponseEntity<>("Logistics Coordinator rejected successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{adminId}/recipients/{recipientId}/accept")
    public ResponseEntity<String> acceptRecipient(@PathVariable Long adminId, @PathVariable Long recipientId) {
        try {
            adminService.acceptRecipient(adminId, recipientId);
            return new ResponseEntity<>("Recipient accepted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{adminId}/recipients/{recipientId}/reject")
    public ResponseEntity<String> rejectRecipient(@PathVariable Long adminId, @PathVariable Long recipientId) {
        try {
            adminService.rejectRecipient(adminId, recipientId);
            return new ResponseEntity<>("Recipient rejected successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
