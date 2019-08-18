package com.trayis.mservice.exceptions

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.StringBuilder

@ControllerAdvice
@RestController
class CustomResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllException(ex: Exception, entity: WebRequest): ResponseEntity<Any> {
        val er = ExceptionResponse(ex.message, entity.getDescription(false))
        val serverError = if (ex is GenericException) ex.status else HttpStatus.INTERNAL_SERVER_ERROR
        return ResponseEntity(er, serverError)
    }

    override fun handleMethodArgumentNotValid(ex: MethodArgumentNotValidException,
                                              headers: HttpHeaders,
                                              status: HttpStatus,
                                              request: WebRequest): ResponseEntity<Any> {
        val exceptionResponse = ExceptionResponse("Invalid parameters", prepareValidationError(ex.bindingResult))
        return ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST)
    }

    private fun prepareValidationError(bindingResult: BindingResult): String {
        val builder = StringBuilder()
        for (error in bindingResult.allErrors) {
            builder.append(error.defaultMessage)
        }
        return builder.toString()
    }

}