package com.example.transactionoutboxpractice.inventory.service

import com.example.transactionoutboxpractice.event.InventoryPaymentEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class InventoryEventService(
    private val eventPublisher: ApplicationEventPublisher
) {
    fun publishInventoryPaymentEvent(event: String) {
        eventPublisher.publishEvent(InventoryPaymentEvent.from(event))
    }
}