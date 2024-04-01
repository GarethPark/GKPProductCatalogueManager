package com.gkpProductCatalogueManager.domain.services.integration

import com.gkpProductCatalogueManager.domain.repositories.ProductRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceIntegrationTest {

    @Autowired
    private lateinit var productRepository: ProductRepository

    @BeforeEach
    fun createProduct(){
        productRepository.deleteAll()
        //TODO Product Service to implement create product method
    }

    @Test
    fun getDeals_returnsDeal() {
        //TODO complete once BeforeEach is implemented
    }
}