package com.hackcrashfiasco.letMeComplainFiasco.service;

import com.hackcrashfiasco.letMeComplainFiasco.domain.TwoFactor;
import com.hackcrashfiasco.letMeComplainFiasco.entity.TwoFactorEntity;
import com.hackcrashfiasco.letMeComplainFiasco.repository.ClockworkSMSRepository;
import com.hackcrashfiasco.letMeComplainFiasco.repository.TwoFactorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class TwoFactorService {


    private ClockworkSMSRepository clockworkSMSRepository;
    private TwoFactorRepository twoFactorRepository;

    @Autowired
    public TwoFactorService(ClockworkSMSRepository clockworkSMSRepository, TwoFactorRepository twoFactorRepository) {
        this.clockworkSMSRepository = clockworkSMSRepository;
        this.twoFactorRepository = twoFactorRepository;
    }

    public TwoFactor sendInitialTwoFactorSms(long telephoneNumber){
        String content = UUID.randomUUID().toString().substring(0,5);
        clockworkSMSRepository.sendSMS(telephoneNumber,content);
        return twoFactorRepository.insert(new TwoFactorEntity(telephoneNumber,content)).toDomain();
    }

    public boolean isTwoFactorValid(String code, long telephoneNumber){
        Optional<TwoFactorEntity> entity =twoFactorRepository.findTwoFactorEntityByTelephoneNumber(telephoneNumber)
                .filter((twoFactorEntity)-> twoFactorEntity.getCode().equals(code));
        AtomicBoolean valid = new AtomicBoolean();
        entity.ifPresent(twoFactorEntity -> {
            valid.set(true);
            twoFactorRepository.delete(twoFactorEntity);
        });
        return valid.get();
    }
}
