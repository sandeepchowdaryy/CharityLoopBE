package com.Donation.Project.controllers;

import com.Donation.Project.entities.LogisticsCoordinatorEntity;
import com.Donation.Project.services.LogisticsCoordinatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/logisticsController")
@CrossOrigin
public class LogisticsCoordinatorController {
    private final LogisticsCoordinatorService logisticsCoordinatorService;

    @PostMapping
    public ResponseEntity<LogisticsCoordinatorEntity> createNewCoordinator(@RequestBody LogisticsCoordinatorEntity logisticsCoordinatorEntity) {
        try{
            LogisticsCoordinatorEntity newentity = logisticsCoordinatorService.createCoordinator(logisticsCoordinatorEntity);
            return new ResponseEntity<>(newentity, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<List<LogisticsCoordinatorEntity>> getAllCoordinators() {
        try{
            List<LogisticsCoordinatorEntity> newentity = logisticsCoordinatorService.getAllCoordinators();
            return new ResponseEntity<>(newentity, HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }



}
