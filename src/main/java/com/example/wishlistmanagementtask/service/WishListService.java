package com.example.wishlistmanagementtask.service;

import com.example.wishlistmanagementtask.dto.RequestDto.WishListItemRequestDto;
import org.springframework.http.ResponseEntity;
// Documentation
public interface WishListService {
    public ResponseEntity getCustomerWishlist(String userName);

    public ResponseEntity addWishListItem(WishListItemRequestDto wishListItemRequestDto);

   public ResponseEntity deleteItem(long id);
}
