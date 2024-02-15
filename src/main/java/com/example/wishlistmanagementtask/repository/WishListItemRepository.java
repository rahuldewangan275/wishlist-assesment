package com.example.wishlistmanagementtask.repository;

import com.example.wishlistmanagementtask.model.WishListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListItemRepository extends JpaRepository<WishListItem,Long> {

}
