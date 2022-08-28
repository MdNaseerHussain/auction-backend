package com.auction.live.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auction.live.models.User;

public interface UserRepository extends MongoRepository<User, BigInteger> {

    public User findByEmail(String email);

    public boolean existsByEmail(String email);

}
