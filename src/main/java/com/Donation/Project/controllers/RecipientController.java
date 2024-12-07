package com.Donation.Project.controllers;

import com.Donation.Project.entities.RecipientEntity;
import com.Donation.Project.services.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/recipient")
@CrossOrigin
public class RecipientController {
    private final RecipientService recipientService;
    @PostMapping
    public ResponseEntity<RecipientEntity> creteNewRecipient(@RequestBody RecipientEntity recipientEntity) {
        try{
            RecipientEntity newRecipient =   recipientService.createNewRecipient(recipientEntity);
            return new ResponseEntity<>(newRecipient, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<RecipientEntity>> getAllRecipient(){
        try{
            List<RecipientEntity> newRecipient =   recipientService.getAllRecipient();
            return new ResponseEntity<>(newRecipient, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
