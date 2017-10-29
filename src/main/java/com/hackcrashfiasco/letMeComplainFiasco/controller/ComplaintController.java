package com.hackcrashfiasco.letMeComplainFiasco.controller;

import com.hackcrashfiasco.letMeComplainFiasco.domain.Complaint;
import com.hackcrashfiasco.letMeComplainFiasco.representations.ComplaintRepresentation;
import com.hackcrashfiasco.letMeComplainFiasco.service.ComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

    private ComplaintsService complaintsService;

    @Autowired
    public ComplaintController(ComplaintsService complaintsService){

        this.complaintsService = complaintsService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ComplaintRepresentation createComplaint(@RequestBody ComplaintRepresentation complaintRepresentation){
        Complaint complaint = complaintsService.saveComplaint(new Complaint(complaintRepresentation));
        return new ComplaintRepresentation(complaint);
    }




}
