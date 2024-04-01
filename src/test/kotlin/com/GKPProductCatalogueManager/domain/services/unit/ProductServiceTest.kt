package com.gkpProductCatalogueManager.domain.services.unit

import com.gkpProductCatalogueManager.domain.services.ProductService
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach


class ProductServiceTest {

    private lateinit var productService: ProductService

    @BeforeEach
    fun setup(){
        productService = ProductService()
    }

    @Test
    fun getProductsWithValidProductId_shouldReturnProduct(){

        val productResponse = productService.getProduct(1)
        assertThat(productResponse).isNotNull()  //.extracting("id").isEqualTo(1L)
    }
}