package com.bel.training.ims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bel.training.ims.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

