package com.tutorial.ecommerce_be.service;

import com.tutorial.ecommerce_be.api.model.RegistrationBody;
import com.tutorial.ecommerce_be.exception.UserAlreadyExistsException;
import com.tutorial.ecommerce_be.model.LocalUser;
import com.tutorial.ecommerce_be.model.dao.LocalUserDAO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    private LocalUserDAO localUserDAO;

    public UserService(LocalUserDAO localUserDAO) {
        this.localUserDAO = localUserDAO;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if(localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent() || localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        LocalUser user = new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setPassword(registrationBody.getPassword());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        //encrypt password
        user.setPassword(registrationBody.getPassword());

        return localUserDAO.save(user);
    }
}
