package com.example.foo.exceptions

import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.servlet.http.HttpServletRequest
import com.example.foo.model.ErrorBody
import kotlin.Error

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(Exception::class)
    fun handleServerError(exception: Exception, request: HttpServletRequest): ResponseEntity<String>{
        return ResponseEntity("INTERNAL_SERVER_ERROR",HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(DataAccessException::class)
    fun handleDataAccessException(exception: Exception, request: HttpServletRequest): ResponseEntity<String>{
        return ResponseEntity("DATABASE_SERVER_ERROR",HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(TokenException::class)
    fun handleTokenException(exception: Exception, request: HttpServletRequest): ResponseEntity<ErrorBody> {
        return ResponseEntity(ErrorBody(exception.message), HttpStatus.BAD_REQUEST)
    }
}