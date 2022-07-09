package com.stanisev.nft.nftgeneratorbe.repository;

import com.stanisev.nft.nftgeneratorbe.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
