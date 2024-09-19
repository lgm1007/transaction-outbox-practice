package com.example.transactionoutboxpractice.inventory.service

interface InventoryCommand {
    fun updateCountByItem(item: String)
}