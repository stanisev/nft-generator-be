package com.stanisev.nft.nftgeneratorbe.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public UserEntity(String name) {
        this.name = name;
    }

    public UserEntity() {

    }
}
