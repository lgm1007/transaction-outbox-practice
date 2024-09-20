package com.example.transactionoutboxpractice.event.service

import com.example.transactionoutboxpractice.event.InventoryPaymentEvent
import com.example.transactionoutboxpractice.event.persistent.repository.EventRecordRepository
import com.example.transactionoutboxpractice.kafka.MessageSendHandler
import org.springframework.stereotype.Service
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Service
class InventoryPaymentEventListener(
    private val eventRecordRepository: EventRecordRepository,
    private val messageSendHandler: MessageSendHandler,
) {
    // 이벤트 outbox 테이블에 기록 (Before Commit)
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    fun recordEvent(inventoryPaymentEvent: InventoryPaymentEvent) {
        eventRecordRepository.save(inventoryPaymentEvent.toEventRecord())
    }

    // 카프카 메시지 전달 (After Commit)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun sendMessage(inventoryPaymentEvent: InventoryPaymentEvent) {
        messageSendHandler.sendEventMessage(inventoryPaymentEvent.event)
    }
}