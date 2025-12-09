package com.practice.kmm.models.entities

/**
 * Represents a payment card for checkout.
 */
data class PaymentCard(
    val id: String,
    val type: CardType,
    val lastFourDigits: String,
    val expiryDate: String,
    val isSelected: Boolean = false
)

/**
 * Supported card types.
 */
enum class CardType {
    VISA,
    MASTERCARD,
    AMEX
}
