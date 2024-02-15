package com.example.wishlistmanagementtask.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @JoinColumn
    @OneToOne
    User user;

    @OneToMany(mappedBy = "wishList" , cascade = CascadeType.ALL)  // parent to child
    List<WishListItem> wishListItemList = new ArrayList<>();

}
