package com.trayis.mservice.controllers

import com.trayis.mservice.beans.User
import com.trayis.mservice.exceptions.GenericException
import com.trayis.mservice.services.UserDaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Resource
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/users")
class UsersController {

    @Autowired
    lateinit var userDaoService: UserDaoService

    @GetMapping
    fun retrieveUsers(): List<User>? {
        return userDaoService.findAll()
    }

    @PostMapping
    fun saveUser(@Valid @RequestBody user: User): Any {
        val savedUser = userDaoService.save(user)
        val uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.id)
                .toUri()
        return ResponseEntity.created(uri).build<Any>()
    }

    @GetMapping("/{id}")
    fun findOneUser(@PathVariable id: Int): Resource<User> {
        return userDaoService.findOne(id)?.let {
            val res = Resource(it)
            val linkTo = linkTo(methodOn(this.javaClass).retrieveUsers())
            res.add(linkTo.withRel("all-users"))
            res
        } ?: throw GenericException("User with id $id not found", HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Int): User {
        return userDaoService.deleteUser(id)
                ?: throw GenericException("User with id $id not found", HttpStatus.NOT_FOUND)
    }

}