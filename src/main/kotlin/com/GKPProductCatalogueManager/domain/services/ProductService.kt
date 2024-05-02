package com.gkpProductCatalogueManager.domain.services

import com.gkpProductCatalogueManager.domain.models.Product
import com.gkpProductCatalogueManager.domain.repositories.ProductRepository
import kotlin.NoSuchElementException

class ProductService (
    private val productRepository : ProductRepository

) {
    fun getProduct(id: Long = 0L): Product {
        return this.productRepository.findById(id).orElseThrow(){NoSuchElementException("Product does not exist with this id")}
    }

    fun getAllProducts(): List<Product>{
        return this.productRepository.findAll()
    }

    fun createProduct(product: Product): Product{
        if (product.name == null) {
            throw IllegalArgumentException("Product name cannot be null")
        }
        return this.productRepository.save(product)
    }
}