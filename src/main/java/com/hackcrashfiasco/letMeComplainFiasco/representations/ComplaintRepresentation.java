package com.hackcrashfiasco.letMeComplainFiasco.representations;

import com.hackcrashfiasco.letMeComplainFiasco.domain.Complaint;
import com.hackcrashfiasco.letMeComplainFiasco.enums.LocationType;

import java.time.LocalDateTime;
import java.util.Map;

public class ComplaintRepresentation {

    private LocalDateTime dateRegistered;
    private String id;
    private String complaintType;
    private LocationType locationType;
    private String link;
    private Map<String, Float> latLng;
    private String content;
    private String userId;
    private String businessName;

    public ComplaintRepresentation(){}

    public ComplaintRepresentation(Complaint complaint) {
        id = complaint.getId().orElseThrow(RuntimeException::new);
        complaintType = complaint.getComplaintType();
        locationType  = complaint.getLocationType();
        link = complaint.getLink();
        latLng = complaint.getLatLng();
        content = complaint.getContent();
        userId = complaint.getUserId();
        businessName = complaint.getBusinessName();
        dateRegistered = complaint.getDateRegistered();
    }

    public LocalDateTime getDateRegistered() {
        return dateRegistered;
    }

    public String getId() {
        return id;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public Map<String, Float> getLatLng() {
        return latLng;
    }

    public String getLink() {
        return link;
    }

    public String getContent() {
        return content;
    }

    public String getUserId() {
        return userId;
    }

    public String getBusinessName() {
        return businessName;
    }
}
