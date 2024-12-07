package com.Donation.Project.services;


import com.Donation.Project.entities.DonorEntity;

import java.util.List;

public interface DonorService {
    DonorEntity createDonor(DonorEntity donorEntity);

    List<DonorEntity> getAllDonors();

    DonorEntity getDonorByID(Long donorId);
}
