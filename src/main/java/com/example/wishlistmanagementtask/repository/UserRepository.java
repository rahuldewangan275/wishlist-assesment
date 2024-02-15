package com.example.wishlistmanagementtask.repository;

import com.example.wishlistmanagementtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from user where email = :email",nativeQuery = true)
    public User findByEmail(String email);
}
