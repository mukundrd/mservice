package com.trayis.mservice.controllers

import com.trayis.mservice.beans.SomeBean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FilteringController {

    @GetMapping("/filters")
    fun retrieveSomeBean(): SomeBean {
        return SomeBean("Value 1", "Value 2", "Value 3")
    }

}