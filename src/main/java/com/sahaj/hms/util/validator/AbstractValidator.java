package com.sahaj.hms.util.validator;

import com.sahaj.hms.common.Validator;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class AbstractValidator<T> implements Validator<T> {

    protected ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    protected javax.validation.Validator validator = factory.getValidator();

    @Override
    public boolean isValid(T t) {
        return false;
    }
}
