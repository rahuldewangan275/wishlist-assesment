package com.example.wishlistmanagementtask.controller;

import com.example.wishlistmanagementtask.dto.RequestDto.WishListItemRequestDto;
import com.example.wishlistmanagementtask.model.WishListItem;
import com.example.wishlistmanagementtask.service.WishListService;
import com.example.wishlistmanagementtask.service.impl.WishListServiceImpl;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/wishlist")
@RestController
public class WishListController {

    @Autowired
    WishListServiceImpl wishListServiceImpl;
//1. get Customer
    @GetMapping("/get")
    public ResponseEntity getCustomerWishlist(){
        //getting current logged user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName(); // I Have Used Email As Name of user

        ResponseEntity response = wishListServiceImpl.getCustomerWishlist(userName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//2. add Wishlist Item to the Wishlist
    @PostMapping("/add")
    public ResponseEntity addWishListItem(@RequestBody WishListItemRequestDto wishListItemRequestDto){

        try {

            ResponseEntity response = wishListServiceImpl.addWishListItem(wishListItemRequestDto);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteItem(@RequestParam("id") long id){
        try{
            ResponseEntity response = wishListServiceImpl.deleteItem(id);
            return response;
        }catch(Exception e){
            return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
        }
    }
}
