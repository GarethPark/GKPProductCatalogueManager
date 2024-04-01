package com.gkpProductCatalogueManager.domain.repositories

import com.gkpProductCatalogueManager.domain.models.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
    // No need to explicitly define a method to find a product by its ID;
    // JpaRepository already provides findById(ID id).
}