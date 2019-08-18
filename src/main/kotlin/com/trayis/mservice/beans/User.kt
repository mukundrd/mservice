package com.trayis.mservice.beans

import javax.validation.constraints.Size

data class User(var id: Int?,
                @field:Size(min = 2, message = "Name should have at least 2 characters") val name: String,
                val birthDate: Long)