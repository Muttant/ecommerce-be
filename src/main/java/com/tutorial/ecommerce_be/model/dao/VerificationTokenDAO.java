package com.tutorial.ecommerce_be.model.dao;

import com.tutorial.ecommerce_be.model.LocalUser;
import com.tutorial.ecommerce_be.model.VerificationToken;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface VerificationTokenDAO extends ListCrudRepository<VerificationToken, Long> {

    Optional<VerificationToken> findByToken(String token);

    void deleteByUser(LocalUser user);
}
