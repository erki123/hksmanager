package com.example.hksmanager.repository;

import com.example.hksmanager.component.Eshop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EshopRepository extends JpaRepository<Eshop, Long> {

    void deleteItemById(Long id);

    Optional<Eshop> findItemById(Long id);
}
