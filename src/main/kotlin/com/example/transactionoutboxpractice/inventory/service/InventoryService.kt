package com.example.transactionoutboxpractice.inventory.service

import com.example.transactionoutboxpractice.inventory.persistent.repository.InventoryRepository
import com.example.transactionoutboxpractice.utils.fail
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InventoryService(
    private val inventoryRepository: InventoryRepository
) : InventoryCommand {
    @Transactional
    override fun updateCountByItem(item: String) {
        val inventory = inventoryRepository.findByItem(item) ?: fail("Item: ${item}에 해당하는 Inventory가 존재하지 않습니다.")

        inventory.increaseCount()
    }
}