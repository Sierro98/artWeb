package com.warsen.artWeb.service.interfaces;

import com.warsen.artWeb.dto.UserDto;
import com.warsen.artWeb.errors.exceptions.UserAlreadyExistException;
import com.warsen.artWeb.model.User;

public interface IUserService {
    User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException;
}
