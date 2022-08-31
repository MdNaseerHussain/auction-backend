package com.auction.live.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auction.live.models.User;

public interface UserRepository extends MongoRepository<User, BigInteger> {

    public Optional<User> findByEmail(String email);

    public boolean existsByEmail(String email);

}
