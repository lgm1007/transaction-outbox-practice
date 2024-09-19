package com.example.transactionoutboxpractice.inventory.service

import com.example.transactionoutboxpractice.inventory.persistent.repository.InventoryRepository
import com.example.transactionoutboxpractice.utils.fail
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InventoryService(
    private val inventoryRepository: InventoryRepository,
    private val inventoryEventService: InventoryEventService,
) : InventoryCommand {

    // Transactional Outbox 적용 - DB 상태 변경과 이벤트를 한 트랜잭션에서 관리하기
    @Transactional
    fun updatePaymentInventoryItem(item: String) {
        // 1. 도메인 로직
        updateCountDecreaseByItem(item)

        // 2. 이벤트 발행
        inventoryEventService.publishInventoryPaymentEvent("InventoryPaymentEvent")
    }

    override fun updateCountDecreaseByItem(item: String) {
        val inventory = inventoryRepository.findByItem(item) ?: fail("Item: ${item}에 해당하는 Inventory가 존재하지 않습니다.")

        inventory.decreaseCount()
    }
}