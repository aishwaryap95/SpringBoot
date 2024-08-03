package com.example.SpringBootRestRepo.service;

import com.example.SpringBootRestRepo.entity.Wand;
import com.example.SpringBootRestRepo.repository.CharacterRepo;
import com.example.SpringBootRestRepo.repository.WandRepo;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServices {

    @Autowired
    private CharacterRepo characterRepo;

    @Autowired
    private WandRepo wandRepo;


}
