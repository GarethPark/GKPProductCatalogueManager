package com.gkpProductCatalogueManager.domain.models

import jakarta.persistence.*
@Entity
@Table(schema = "PRODUCT_OWNER", name = "PRODUCT")
data class Product(
    @Column(name = "ID")
    var id: Long? = null
)

