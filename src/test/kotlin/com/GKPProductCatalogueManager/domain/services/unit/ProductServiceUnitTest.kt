package com.gkpProductCatalogueManager.domain.services.unit

import com.gkpProductCatalogueManager.domain.models.Product
import com.gkpProductCatalogueManager.domain.repositories.ProductRepository
import com.gkpProductCatalogueManager.domain.services.ProductService
import com.gkpProductCatalogueManager.testUtils.ProductDataFactory
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.*
import java.util.Optional


class ProductServiceUnitTest {

    private lateinit var productService: ProductService
    private lateinit var productRepository: ProductRepository

    @BeforeEach
    fun setup(){
        productRepository = mock()
        productService = ProductService(productRepository)
    }

    @Test
    fun getProductsWithValidProductId_shouldReturnProduct(){
        val existingProduct = ProductDataFactory.TestProduct.validProduct(1)

        `when`(productRepository.findById(anyLong())).thenReturn(Optional.of(existingProduct))
        val productResponse = productService.getProduct(1)
        assertThat(productResponse).isNotNull.extracting("id").isEqualTo(1L)
    }

    @Test
    fun getProductWithInvalidProductId_shouldReturnError(){
        assertThrows<NoSuchElementException> {
            productService.getProduct(1)
        }
    }

    @Test
    fun getAllProductsWhenExist_shouldReturnAllProducts(){
        val existingProduct1 = ProductDataFactory.TestProduct.validProduct(1)
        val existingProduct2 = ProductDataFactory.TestProduct.validProduct(2)
        val existingProduct3 = ProductDataFactory.TestProduct.validProduct(3)
        val existingProducts : MutableList<Product> = mutableListOf()

        existingProducts.add(existingProduct1)
        existingProducts.add(existingProduct2)
        existingProducts.add(existingProduct3)

        `when`(productRepository.findAll()).thenReturn(existingProducts)

        val productResponse = productService.getAllProducts()
        assertThat(productResponse).isNotNull.hasSize(3)
    }

    @Test
    fun getAllProductsWhenNoneExist_shouldReturnAnEmptyList(){

        val productResponse = productService.getAllProducts()
        assertThat(productResponse).isNotNull.hasSize(0)
    }
}