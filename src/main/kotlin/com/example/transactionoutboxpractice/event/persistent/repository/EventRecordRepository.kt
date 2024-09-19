package com.example.transactionoutboxpractice.event.persistent.repository

import com.example.transactionoutboxpractice.event.persistent.entity.EventRecord
import org.springframework.data.jpa.repository.JpaRepository

interface EventRecordRepository : JpaRepository<EventRecord, Long> {
    fun findByEvent(event: String): EventRecord?
}