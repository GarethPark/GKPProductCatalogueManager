package com.gkpProductCatalogueManager.domain.services

import com.gkpProductCatalogueManager.domain.models.Product
import com.gkpProductCatalogueManager.domain.repositories.ProductRepository
import java.util.*

class ProductService (
    private val productRepository : ProductRepository

) {
    fun getProduct(id: Long = 0L): Optional<Product> {
        return productRepository.findById(id)
    }
}