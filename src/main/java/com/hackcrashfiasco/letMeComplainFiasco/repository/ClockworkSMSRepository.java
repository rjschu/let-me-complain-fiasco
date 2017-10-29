package com.hackcrashfiasco.letMeComplainFiasco.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ClockworkSMSRepository {

    private static final String API_KEY = "75e8b095b26288791d855d965e62c40429e0a644";
    private static final String BASE_URL = "https://api.clockworksms.com/http/%s";

    public void sendSMS(long to, String content){
        RestTemplate template = new RestTemplate();
        String toString = "44"+to;
        String stuff = template.getForObject(String.format(BASE_URL+"?key=%s&to=%s&content=%s","send.aspx",API_KEY,toString,content),String.class);
        System.out.println(stuff);
    }

}
