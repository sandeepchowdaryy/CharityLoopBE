package com.Donation.Project.services.impl;

import com.Donation.Project.entities.DonorEntity;
import com.Donation.Project.repositories.DonorRepository;
import com.Donation.Project.services.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;

    @Override
    public DonorEntity createDonor(DonorEntity donorEntity) {
        return donorRepository.save(donorEntity);
    }

    @Override
    public List<DonorEntity> getAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public DonorEntity getDonorByID(Long donorId) {
        return donorRepository.findById(donorId).orElse(null);
    }
}
