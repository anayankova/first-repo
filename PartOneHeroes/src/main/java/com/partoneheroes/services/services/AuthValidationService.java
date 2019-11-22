package com.partoneheroes.services.services;

import com.partoneheroes.services.models.auth.RegisterUserServiceModel;

public interface AuthValidationService {
    boolean isValid(RegisterUserServiceModel user);
}
