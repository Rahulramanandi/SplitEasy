package com.rahul.spliteasy.service.interfaces;

import com.rahul.spliteasy.persistence.dto.user.RegisterUserRequest;
import com.rahul.spliteasy.persistence.dto.user.UserDTO;

public interface UserService {
    String saveUser(RegisterUserRequest registerUserRequest);

    UserDTO findUser();

    String deleteUser();

    String updateUser(RegisterUserRequest registerUserRequest);

}
