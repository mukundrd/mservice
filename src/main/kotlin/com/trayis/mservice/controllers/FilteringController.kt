package com.trayis.mservice.controllers

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import com.trayis.mservice.beans.SomeBean
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FilteringController {

    @GetMapping("/filters")
    fun retrieveSomeBean(): SomeBean {
        return SomeBean("Value 1", "Value 2", "Value 3")
    }

    @GetMapping("/filters_dynamic")
    fun retrieveSomeDynamicBean(): MappingJacksonValue {
        val bean = SomeBean("Value 1", "Value 2", "Value 3")
        val mapping = MappingJacksonValue(bean)
        val filter  = SimpleBeanPropertyFilter.filterOutAllExcept("v2")
        val filters = SimpleFilterProvider().addFilter("SomeBeanFilter", filter)
        mapping.filters = filters
        return mapping
    }

}