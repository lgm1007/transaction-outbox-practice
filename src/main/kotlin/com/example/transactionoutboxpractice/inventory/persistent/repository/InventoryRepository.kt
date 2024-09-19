package com.example.transactionoutboxpractice.inventory.persistent.repository

import com.example.transactionoutboxpractice.inventory.persistent.entity.Inventory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface InventoryRepository : JpaRepository<Inventory, Long> {
    fun findByItem(item: String): Inventory?
}