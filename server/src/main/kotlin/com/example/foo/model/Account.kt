package com.example.foo.model

import javax.persistence.*

@Entity
data class Account(@Id @GeneratedValue(strategy=GenerationType.AUTO) var id: Long,
                   @Column(name="account_number") var accountNumber: String,
                   var password: String,
                   var balance: Double)