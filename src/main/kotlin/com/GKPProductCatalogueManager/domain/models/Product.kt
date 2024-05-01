package com.gkpProductCatalogueManager.domain.models

import jakarta.persistence.*
@Entity
@Table(schema = "PRODUCT_OWNER", name = "PRODUCT")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,
    @Column(name = "NAME")
    var name: String? = null
)

