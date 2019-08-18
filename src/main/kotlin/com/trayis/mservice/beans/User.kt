package com.trayis.mservice.beans

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
data class User(@Id @GeneratedValue var id: Int?,
                @field:Size(min = 2, message = "Name should have at least 2 characters") val name: String,
                val birthDate: Long)