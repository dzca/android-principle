package com.example.foo.repository

import com.example.foo.model.Account
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface AccountRepository : CrudRepository<Account, Long> {
    @Query("SELECT a FROM Account a where a.accountNumber = :accountNumber")
    fun findByAccountNumber(@Param("accountNumber") accountNumber: String): List<Account>

    @Transactional
    @Modifying
    @Query("DELETE FROM Account a where a.accountNumber = :accountNumber")
    fun deleteByAccountNumber(@Param("accountNumber") accountNumber: String)

}
