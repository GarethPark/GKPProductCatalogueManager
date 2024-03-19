package com.GKPProductCatalogueManager.web.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello World"
    }
}