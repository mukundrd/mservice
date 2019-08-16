package com.trayis.mservice.controllers

import com.trayis.mservice.beans.HelloBean
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/hello-world", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getHelloWorld() = "{\"message\":\"Hello World\"}"

    @GetMapping("/hello-world-bean", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getHelloWorldBean() = HelloBean("Hello World")

    @GetMapping("/hello-world-bean/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getHelloWorldBeanParam(@PathVariable id: String) = HelloBean("Hello World - $id" )

}