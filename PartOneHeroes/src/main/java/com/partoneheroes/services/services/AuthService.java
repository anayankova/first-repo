package com.partoneheroes.services.services;

import com.partoneheroes.services.models.LoginUserServiceModel;
import com.partoneheroes.services.models.auth.RegisterUserServiceModel;

public interface AuthService {
    void register(RegisterUserServiceModel model);

    LoginUserServiceModel login(RegisterUserServiceModel serviceModel) throws Exception;
}