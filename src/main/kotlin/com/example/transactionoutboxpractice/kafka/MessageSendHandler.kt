package com.example.transactionoutboxpractice.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class MessageSendHandler(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    private val eventRecordTopic = "topic.event.record"

    fun sendEventMessage(event: String) {
        kafkaTemplate.send(eventRecordTopic, event)
    }
}