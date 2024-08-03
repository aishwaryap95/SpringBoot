package com.example.SpringBootRestRepo.repository;

import com.example.SpringBootRestRepo.entity.FictionalCharacter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CharacterRepo extends JpaRepository<FictionalCharacter , Integer> {

}
