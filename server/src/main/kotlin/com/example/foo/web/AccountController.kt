package com.example.foo.web


import com.example.foo.model.Account
import com.example.foo.repository.AccountRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(val repository: AccountRepository) {

    @GetMapping
    fun findAllAccounts() = repository.findAll()

    @PostMapping
    fun addAccount(@RequestBody account: Account) = repository.save(account)

    @PutMapping("/{accountNumber}")
    fun updateAccount(@PathVariable accountNumber: String, @RequestBody Account: Account) {
        assert(Account.accountNumber == accountNumber)
        repository.save(Account)
    }

    @DeleteMapping("/{accountNumber}")
    fun removeAccount(@PathVariable accountNumber: String)
            = repository.deleteByAccountNumber(accountNumber)

    @GetMapping("/{accountNumber}")
    fun getByAccountNumber(@PathVariable accountNumber: String)
            = repository.findByAccountNumber(accountNumber)
}