package com.gkpProductCatalogueManager.testUtils

import com.gkpProductCatalogueManager.domain.models.Product
import java.math.BigDecimal

class ProductDataFactory {
    class TestProduct{
        companion object{
            fun validProduct(id: Long? = null, name: String? = null, price: BigDecimal): Product {
                val product = Product(id = id, name = name, price = price)
                return product
            }
        }
    }
}