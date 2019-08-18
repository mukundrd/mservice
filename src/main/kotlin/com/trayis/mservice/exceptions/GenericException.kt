package com.trayis.mservice.exceptions

import org.springframework.http.HttpStatus

class GenericException(message: String, val status: HttpStatus) : RuntimeException(message)
