package com.hackcrashfiasco.letMeComplainFiasco.entity;

import com.hackcrashfiasco.letMeComplainFiasco.domain.TwoFactor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "twoFactor")
public class TwoFactorEntity {

    @Id
    private ObjectId id;
    private long telephoneNumber;
    private String code;

    public TwoFactorEntity() {
    }

    public TwoFactorEntity(long telephoneNumber, String content) {

        this.telephoneNumber = telephoneNumber;
        this.code = content;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getCode() {
        return code;
    }


    public TwoFactor toDomain(){
        TwoFactor twoFactor = new TwoFactor();
        twoFactor.setCode(code);
        twoFactor.setTelephoneNumber(telephoneNumber);

        return twoFactor;
    }
}
