package com.example.wishlistmanagementtask.repository;

import com.example.wishlistmanagementtask.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long> {

}
