package com.example.wishlistmanagementtask.model;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(nullable = false)
    String name;

    @Email
    @Column(nullable = false)
    String email;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    WishList wishList;

}
