package com.trayis.mservice.controllers

import com.trayis.mservice.beans.Name
import com.trayis.mservice.beans.PersonV1
import com.trayis.mservice.beans.PersonV2
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    @GetMapping("/v1/person")
    fun personV1() = PersonV1("Bob Charlie")

    @GetMapping("/v2/person")
    fun personV2() = PersonV2(Name("Bob", "Charlie"))

    @GetMapping("/person/param", params = ["version = 1"])
    fun param1() = PersonV1("Bob Charlie")

    @GetMapping("/person/param", params = ["version = 2"])
    fun param2() = PersonV2(Name("Bob", "Charlie"))

    @GetMapping("/person/header", headers = ["version = 1"])
    fun headerParam1() = PersonV1("Bob Charlie")

    @GetMapping("/person/header", headers = ["version = 2"])
    fun headerParam2() = PersonV2(Name("Bob", "Charlie"))

}