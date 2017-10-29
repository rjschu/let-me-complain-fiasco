package com.hackcrashfiasco.letMeComplainFiasco.entity;

import com.hackcrashfiasco.letMeComplainFiasco.domain.Complaint;
import com.hackcrashfiasco.letMeComplainFiasco.enums.LocationType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "complaint")
public class ComplaintEntity {

    @Id
    private ObjectId id;
    private String complaintType;
    private LocationType locationType;
    private String link;
    private String businessName;
    private Map<String, Float> latLng;
    private String content;
    private String userId;
    private LocalDateTime dateRegistered = LocalDateTime.now();

    public ComplaintEntity(){}

    public ComplaintEntity(Complaint complaint) {

        complaint.getId().ifPresent((oid)-> id = new ObjectId(oid));
        complaintType = complaint.getComplaintType();
        locationType = complaint.getLocationType();
        link = complaint.getLink();
        latLng = complaint.getLatLng();
        content = complaint.getContent();
        userId = complaint.getUserId();
        businessName = complaint.getBusinessName();
    }

    public ObjectId getId() {
        return id;
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

    public String getUserId() {
        return userId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public LocalDateTime getDateRegistered() {
        return dateRegistered;
    }

    public Complaint toDomain(){

        Complaint complaint = new Complaint();

        complaint.setId(id.toHexString());
        complaint.setComplaintType(complaintType);
        complaint.setLocationType(locationType);
        complaint.setLatLng(latLng);
        complaint.setLink(link);
        complaint.setContent(content);
        complaint.setUserId(userId);
        complaint.setBusinessName(businessName);
        complaint.setDateRegistered(dateRegistered);

        return complaint;
    }
}
