package com.hackcrashfiasco.letMeComplainFiasco.domain;

import com.hackcrashfiasco.letMeComplainFiasco.enums.LocationType;
import com.hackcrashfiasco.letMeComplainFiasco.representations.ComplaintRepresentation;

import java.util.Map;
import java.util.Optional;

public class Complaint {
    private String id;
    private String complaintType;
    private LocationType locationType;
    private Map<String, Float> latLng;
    private String link;
    private String content;

    public Complaint(ComplaintRepresentation complaintRepresentation) {
        complaintType = complaintRepresentation.getComplaintType();
        locationType = complaintRepresentation.getLocationType();
        latLng = complaintRepresentation.getLatLng();
        link = complaintRepresentation.getLink();
        content = complaintRepresentation.getContent();
    }

    public Complaint() {

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public void setLatLng(Map<String, Float> latLng) {
        this.latLng = latLng;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Optional<String> getId() {
        return Optional.ofNullable(id);
    }

    public String getComplaintType() {
        return complaintType;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public String getLink() {
        return link;
    }

    public Map<String, Float> getLatLng() {
        return latLng;
    }

    public String getContent() {
        return content;
    }
}