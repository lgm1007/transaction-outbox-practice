package com.example.transactionoutboxpractice.inventory.service

interface InventoryCommand {
    fun updateCountDecreaseByItem(item: String)
}