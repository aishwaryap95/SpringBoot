package com.example.SpringBootRestRepo.repository;

import com.example.SpringBootRestRepo.entity.Wand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WandRepo extends JpaRepository<Wand, Integer> {
}
