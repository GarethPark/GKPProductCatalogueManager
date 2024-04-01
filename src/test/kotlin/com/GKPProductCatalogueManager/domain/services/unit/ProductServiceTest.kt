package com.gkpProductCatalogueManager.domain.services.unit

import com.gkpProductCatalogueManager.domain.models.Product
import com.gkpProductCatalogueManager.domain.repositories.ProductRepository
import com.gkpProductCatalogueManager.domain.services.ProductService
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.*
import java.util.Optional


class ProductServiceTest {

    private lateinit var productService: ProductService
    private lateinit var productRepository: ProductRepository

    @BeforeEach
    fun setup(){
        productRepository = mock()
        productService = ProductService(productRepository)
    }

    @Test
    fun getProductsWithValidProductId_shouldReturnProduct(){
        val existingProduct

        `when`(productRepository.findById(anyLong())).thenReturn(Optional.of(existingProduct))
        val productResponse = productService.getProduct(1)
        assertThat(productResponse).isNotNull().extracting("id").isEqualTo(1L)
    }
}