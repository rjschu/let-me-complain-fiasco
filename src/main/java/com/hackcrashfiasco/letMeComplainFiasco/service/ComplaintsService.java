package com.hackcrashfiasco.letMeComplainFiasco.service;

import com.hackcrashfiasco.letMeComplainFiasco.domain.Complaint;
import com.hackcrashfiasco.letMeComplainFiasco.entity.ComplaintEntity;
import com.hackcrashfiasco.letMeComplainFiasco.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintsService {

    private ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintsService(ComplaintRepository complaintRepository){
        this.complaintRepository = complaintRepository;
    }

    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.insert(new ComplaintEntity(complaint)).toDomain();
    }
}
