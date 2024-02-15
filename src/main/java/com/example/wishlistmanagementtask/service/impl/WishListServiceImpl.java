package com.example.wishlistmanagementtask.service.impl;

import com.example.wishlistmanagementtask.dto.RequestDto.WishListItemRequestDto;
import com.example.wishlistmanagementtask.dto.ResponseDto.WishListItemResponseDto;
import com.example.wishlistmanagementtask.model.User;
import com.example.wishlistmanagementtask.model.WishList;
import com.example.wishlistmanagementtask.model.WishListItem;
import com.example.wishlistmanagementtask.repository.UserRepository;
import com.example.wishlistmanagementtask.repository.WishListItemRepository;
import com.example.wishlistmanagementtask.repository.WishListRepository;
import com.example.wishlistmanagementtask.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private  WishListRepository wishListRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WishListItemRepository wishListItemRepository;

    public ResponseEntity getCustomerWishlist(String userName) {
//        Optional<ArrayList> li = wishListRepository.findById(();
//I have used email and user name as same for uniquely identify user
        User user = userRepository.findByEmail(userName);
        if(user==null){
            return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
        }

        System.out.println(user);

        WishList wishList = user.getWishList();

        if(wishList==null){
            WishList wishList1 = new WishList();
            wishList1.setWishListItemList(new ArrayList<>());
            wishListRepository.save(wishList1);
            user.setWishList(wishList1);
            userRepository.save(user);
        }

        wishList = user.getWishList();

        if(wishList==null){
            return new ResponseEntity<>("Cart is Empty",HttpStatus.OK);
        }
        List<WishListItem> wishListItems = wishList.getWishListItemList();
        return new ResponseEntity(wishListItems, HttpStatus.OK);
    }


    public ResponseEntity addWishListItem(WishListItemRequestDto wishListItemRequestDto) {
        //creating new WishListItem from dto
        WishListItem  wishListItem = WishListItem.builder()
                .price(wishListItemRequestDto.getPrice())
                .name(wishListItemRequestDto.getName())
                .build();
        wishListItemRepository.save(wishListItem);

        // Getting Current USer From Authentication
        String userName =getUserName(); // I have used same email and name to uniquely identify a user
        System.out.println(userName);


        User user = userRepository.findByEmail(userName);
        user.getWishList().getWishListItemList().add(wishListItem);
        userRepository.save(user);

        return new ResponseEntity<>("wish item added successfully" , HttpStatus.CREATED);
    }

    //3.
   public ResponseEntity deleteItem(long id){
        Optional<WishListItem> optional = wishListItemRepository.findById(id);
        if(optional.isEmpty()){
            return new ResponseEntity("Item Not Present",HttpStatus.NOT_FOUND);
        }
        WishListItem w = optional.get();
        WishListItemResponseDto wishListItemResponseDto = WishListItemResponseDto.builder()
               .name(w.getName())
               .price(w.getPrice())
               .build();

        wishListItemRepository.deleteById(id);
        return  new ResponseEntity<>("Item :"+wishListItemResponseDto +"\n Item Deleted Successfully",HttpStatus.OK);
    }

   public String getUserName(){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String userName = authentication.getName(); // I have used same email and name to uniquely identify a user
       return userName;
   }

}
