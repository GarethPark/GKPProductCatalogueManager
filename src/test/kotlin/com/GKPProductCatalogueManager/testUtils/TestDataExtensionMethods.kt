package com.gkpProductCatalogueManager.testUtils

import com.gkpProductCatalogueManager.domain.models.Product

class ProductDataFactory {
    class TestProduct{
        companion object{
            fun validProduct(id: Long? = null, name: String? = null): Product {
                val product = Product(id = id, name = name)
                return product
            }
        }
    }
}