package com.example.transactionoutboxpractice.event

import com.example.transactionoutboxpractice.event.persistent.entity.EventRecord

class InventoryPaymentEvent(
    val event: String
) {
    fun toEventRecord(): EventRecord {
        return EventRecord(event)
    }

    companion object {
        fun from(event: String): InventoryPaymentEvent {
            return InventoryPaymentEvent(event)
        }
    }
}