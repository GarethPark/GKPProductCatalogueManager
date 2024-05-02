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
        val existingProducts : MutableList<Product> = mutableListOf(
            ProductDataFactory.TestProduct.validProduct(1),
            ProductDataFactory.TestProduct.validProduct(2),
            ProductDataFactory.TestProduct.validProduct(3)
        )

        `when`(productRepository.findAll()).thenReturn(existingProducts)

        val productResponse = productService.getAllProducts()
        assertThat(productResponse).isNotNull.hasSize(3)
    }

    @Test
    fun getAllProductsWhenNoneExist_shouldReturnAnEmptyList(){

        val productResponse = productService.getAllProducts()
        assertThat(productResponse).isNotNull.hasSize(0)
    }

    @Test
    fun createProductWithValidData_shouldReturnAProductId(){
        val newProduct = Product(name = "TestProduct")
        val savedProduct = ProductDataFactory.TestProduct.validProduct(1, "TestProduct")

        `when`(productRepository.save(any())).thenReturn(savedProduct)
        val productResponse = productService.createProduct(newProduct)
        assertThat(productResponse).isNotNull
        assertThat(productResponse).extracting("name").isEqualTo("TestProduct")

        verify(productRepository, times(1)).save(newProduct)
    }

    @Test
    fun createProductWithInvalidData_shouldReturnAnError(){
        val invalidProduct = Product(name = null)
        val exception = assertThrows<IllegalArgumentException> {
            productService.createProduct(invalidProduct)
        }
        assertThat(exception.message).isEqualTo("Product name cannot be null")

    }

    @Test
    fun updateProductWithValidData_shouldReturnUpdatedProduct(){
        val existingProduct = Product(name = "TestProduct", id = 1L)

        `when`(productRepository.save(any())).thenReturn(existingProduct)
        val productResponse = productService.updateProduct(existingProduct)
        assertThat(productResponse).isNotNull
        assertThat(productResponse).extracting("name").isEqualTo("TestProduct")

        verify(productRepository, times(1)).save(existingProduct)
    }
}