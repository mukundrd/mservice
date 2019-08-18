package com.trayis.mservice.services

import com.trayis.mservice.beans.User
import org.springframework.stereotype.Component

@Component
class UserDaoService {

    companion object {
        val usersList = ArrayList<User>()

        private var usersId = 0

        init {
            usersList.add(User(1, "Amar", System.currentTimeMillis()))
            usersList.add(User(2, "Akbar", System.currentTimeMillis()))
            usersList.add(User(3, "Anthony", System.currentTimeMillis()))

            usersId = usersList.size + 1
        }
    }

    fun findAll() = usersList

    fun save(user: User): User {
        user.id = usersId++
        usersList.add(user)
        return user
    }

    fun findOne(id: Int) = usersList.firstOrNull { id == it.id }

    fun deleteUser(id: Int): User? {
        findOne(id)?.let {
            usersList.remove(it)
            return it
        }
        return null
    }

}