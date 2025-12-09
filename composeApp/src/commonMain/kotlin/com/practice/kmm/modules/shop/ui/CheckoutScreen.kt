package com.practice.kmm.modules.shop.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.models.consts.ShippingMethod
import com.practice.kmm.models.entities.CardType
import com.practice.kmm.models.entities.PaymentCard
import com.practice.kmm.models.entities.Product
import com.practice.kmm.theme.ShopTheme
import com.practice.kmm.uiToolKit.PaymentCardItem
import com.practice.kmm.uiToolKit.PrimaryButton
import com.practice.kmm.uiToolKit.ShippingToggle
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.action_add_new
import practicekmm.composeapp.generated.resources.action_finalize_purchase
import practicekmm.composeapp.generated.resources.label_free
import practicekmm.composeapp.generated.resources.label_including_taxes
import practicekmm.composeapp.generated.resources.label_items
import practicekmm.composeapp.generated.resources.label_select_payment
import practicekmm.composeapp.generated.resources.label_shipping_cost
import practicekmm.composeapp.generated.resources.label_shipping_method
import practicekmm.composeapp.generated.resources.label_subtotal
import practicekmm.composeapp.generated.resources.label_total
import practicekmm.composeapp.generated.resources.title_checkout

/**
 * Checkout screen for completing purchases.
 *
 * @param productId ID of the product being purchased
 * @param onNavigateBack Callback for back navigation
 * @param onFinalizePurchase Callback when purchase is finalized
 * @param modifier Modifier for the screen
 */
@Composable
fun CheckoutScreen(
    productId: String,
    onNavigateBack: () -> Unit,
    onFinalizePurchase: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Demo data
    val product = remember {
        Product(
            id = productId,
            name = "Sony WH-1000XM5",
            price = 4999.0
        )
    }

    val paymentCards = remember {
        listOf(
            PaymentCard(
                id = "1",
                type = CardType.VISA,
                lastFourDigits = "1921",
                expiryDate = "07/25",
                isSelected = true
            ),
            PaymentCard(
                id = "2",
                type = CardType.VISA,
                lastFourDigits = "5632",
                expiryDate = "07/25",
                isSelected = false
            )
        )
    }

    var selectedCardId by remember { mutableStateOf("1") }
    var shippingMethod by remember { mutableStateOf(ShippingMethod.HOME_DELIVERY) }

    val extendedColors = ShopTheme.extendedColors
    val itemCount = 2
    val subtotal = product.price
    val shippingCost = 0.0
    val total = subtotal + shippingCost

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = stringResource(Res.string.title_checkout),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            // Scrollable Content
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                // Product Summary Card
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Product Image Placeholder
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = product.name.take(2).uppercase(),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = product.name,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "$ ${product.price.toInt().toString().reversed().chunked(3).joinToString(",").reversed()}",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = extendedColors.priceText
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "|",
                                color = MaterialTheme.colorScheme.outline
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = stringResource(Res.string.label_including_taxes),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Shipping Method
                Text(
                    text = stringResource(Res.string.label_shipping_method),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(12.dp))

                ShippingToggle(
                    selectedMethod = shippingMethod,
                    onMethodSelected = { shippingMethod = it }
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Payment Method
                Text(
                    text = stringResource(Res.string.label_select_payment),
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Payment Cards
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(paymentCards) { card ->
                        PaymentCardItem(
                            card = card.copy(isSelected = card.id == selectedCardId),
                            onClick = { selectedCardId = card.id }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Add New Payment
                Text(
                    text = stringResource(Res.string.action_add_new),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Payment Method Icons
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    PaymentMethodIcon(text = "G Pay")
                    PaymentMethodIcon(text = "Apple Pay")
                    PaymentMethodIcon(text = "PayPal")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Order Summary
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${stringResource(Res.string.label_subtotal)} ${stringResource(Res.string.label_items, itemCount)}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "$ ${subtotal.toInt().toString().reversed().chunked(3).joinToString(",").reversed()}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(Res.string.label_shipping_cost),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = stringResource(Res.string.label_free),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                HorizontalDivider(color = MaterialTheme.colorScheme.outline)

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(Res.string.label_total),
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "$ ${total.toInt().toString().reversed().chunked(3).joinToString(",").reversed()}",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            // Finalize Button
            PrimaryButton(
                text = stringResource(Res.string.action_finalize_purchase),
                onClick = onFinalizePurchase,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
private fun PaymentMethodIcon(
    text: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .border(
                1.dp,
                MaterialTheme.colorScheme.outline,
                RoundedCornerShape(8.dp)
            )
            .clickable { }
            .padding(horizontal = 20.dp, vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview
@Composable
private fun CheckoutScreenPreview() {
    ShopTheme {
        CheckoutScreen(
            productId = "2",
            onNavigateBack = {},
            onFinalizePurchase = {}
        )
    }
}
