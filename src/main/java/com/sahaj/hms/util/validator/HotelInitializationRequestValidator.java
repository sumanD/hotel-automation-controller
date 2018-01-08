package com.sahaj.hms.util.validator;

import com.sahaj.hms.common.Validator;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Service
public class HotelInitializationRequestValidator extends AbstractValidator<HotelInitializationRequest> {

    @Override
    public boolean isValid(HotelInitializationRequest hotelInitializationRequest) {
        Set<ConstraintViolation<HotelInitializationRequest>> violations = validator.validate(hotelInitializationRequest);
        if(!violations.isEmpty()) {
            return false;
        }
        return true;
    }
}
