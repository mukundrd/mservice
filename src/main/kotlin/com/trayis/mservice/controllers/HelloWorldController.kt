package com.trayis.mservice.controllers

import com.trayis.mservice.beans.HelloBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @Autowired
    lateinit var messageSource: ResourceBundleMessageSource

    @GetMapping("/hello-world", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getHelloWorld() = "{\"message\":\"Hello World\"}"

    @GetMapping("/hello-world-bean", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getHelloWorldBean() = HelloBean("Hello World")

    @GetMapping("/hello-world-locale", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getHelloWorldBeanWithLocale() = HelloBean(messageSource.getMessage("hello.world.message", null, LocaleContextHolder.getLocale()))

    @GetMapping("/hello-world-bean/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getHelloWorldBeanParam(@PathVariable id: String) = HelloBean("Hello World - $id")

}