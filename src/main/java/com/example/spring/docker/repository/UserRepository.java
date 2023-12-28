package com.example.spring.docker.repository;

import com.example.spring.docker.domain.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TestUser, Long> {
    TestUser findByUserName(String userName);
}
