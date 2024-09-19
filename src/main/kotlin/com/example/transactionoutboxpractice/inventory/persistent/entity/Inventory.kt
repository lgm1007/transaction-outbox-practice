package com.example.transactionoutboxpractice.inventory.persistent.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Inventory(
    val item: String,
    var count: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun increaseCount() {
        count++
    }

    fun decreaseCount() {
        count--
    }
}