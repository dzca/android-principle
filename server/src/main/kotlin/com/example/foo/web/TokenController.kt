package com.example.foo.web

import com.example.foo.exceptions.TokenException
import com.example.foo.model.Token
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/token")
class TokenController {

    @GetMapping("/{key}")
    fun getToken(@PathVariable key: String): ResponseEntity<Token> {
        if(key == "qqbb12")
            return ResponseEntity(Token("xxyyzz"), HttpStatus.OK)

        else
            throw TokenException("INVALID_KEY")
    }
}
