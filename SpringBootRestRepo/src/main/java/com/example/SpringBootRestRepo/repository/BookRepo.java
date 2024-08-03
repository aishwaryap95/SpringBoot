package com.example.SpringBootRestRepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringBootRestRepo.entity.Book;

//For SQL CRUD Operations
//To access CRUD methods for standard data access available in a standard DAO
public interface BookRepo extends JpaRepository<Book, Integer> {

}
