package com.trayis.mservice.services

import com.trayis.mservice.UserRepository
import com.trayis.mservice.beans.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserDaoService {

    @Autowired
    lateinit var userRepo: UserRepository

    fun findAll() = userRepo.findAll()

    fun save(user: User): User {
        userRepo.save(user)
        return user
    }

    fun findOne(id: Int) = userRepo.findById(id.toLong())

    fun deleteUser(id: Int): User? {
        findOne(id)?.let {
            usersList.remove(it)
            return it
        }
        return null
    }

}