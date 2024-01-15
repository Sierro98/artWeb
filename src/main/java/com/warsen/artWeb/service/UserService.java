package com.warsen.artWeb.service;

import com.warsen.artWeb.dto.UserDto;
import com.warsen.artWeb.errors.exceptions.UserAlreadyExistException;
import com.warsen.artWeb.model.User;
import com.warsen.artWeb.repository.UserRepository;
import com.warsen.artWeb.service.interfaces.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService(UserRepository repository) implements IUserService {

    private UserRepository userRepository;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: "
                    + userDto.getEmail());
        }

        // the rest of the registration operation
        return null;
    }
    private boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}