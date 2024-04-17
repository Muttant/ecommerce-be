package com.tutorial.ecommerce_be.api.controller.auth;

import com.tutorial.ecommerce_be.api.model.LoginBody;
import com.tutorial.ecommerce_be.api.model.LoginResponse;
import com.tutorial.ecommerce_be.api.model.RegistrationBody;
import com.tutorial.ecommerce_be.exception.UserAlreadyExistsException;
import com.tutorial.ecommerce_be.model.LocalUser;
import com.tutorial.ecommerce_be.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegistrationBody registrationBody){
        try {
            userService.registerUser(registrationBody);
            return ResponseEntity.ok().build();
        } catch (UserAlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody){
        String jwt = userService.loginUser(loginBody);
        if(jwt == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            LoginResponse response = new LoginResponse();
            response.setJwt(jwt);
            return ResponseEntity.ok(response);
        }
    }
    @GetMapping("/me")
    public LocalUser getLoggedInUserProfile(@AuthenticationPrincipal LocalUser user){
        //SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }

}
