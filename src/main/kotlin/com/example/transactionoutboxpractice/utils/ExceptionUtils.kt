package com.example.transactionoutboxpractice.utils

fun fail(message: String?): Nothing {
    throw IllegalArgumentException(message)
}