package com.example.metHotels.repository;

import com.example.metHotels.entity.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShirtRepository extends JpaRepository<Shirt, String> {
}
