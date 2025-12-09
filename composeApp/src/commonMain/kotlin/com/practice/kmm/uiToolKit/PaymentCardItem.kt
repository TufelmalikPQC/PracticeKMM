package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.models.entities.CardType
import com.practice.kmm.models.entities.PaymentCard
import com.practice.kmm.theme.ShopTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Payment card item with gradient background.
 *
 * @param card Payment card data
 * @param onClick Callback when card is clicked
 * @param modifier Modifier for the component
 */
@Composable
fun PaymentCardItem(
    card: PaymentCard,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val extendedColors = ShopTheme.extendedColors

    val gradient = when {
        card.isSelected -> Brush.linearGradient(
            colors = listOf(extendedColors.cardOrangeStart, extendedColors.cardOrangeEnd)
        )
        else -> Brush.linearGradient(
            colors = listOf(extendedColors.cardPurpleStart, extendedColors.cardPurpleEnd)
        )
    }

    Box(
        modifier = modifier
            .width(160.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(gradient)
            .clickable(onClick = onClick)
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = card.type.name,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Spacer(modifier = Modifier.weight(1f))

                if (card.isSelected) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "**** **** **** ${card.lastFourDigits}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.9f)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = card.expiryDate,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
            )
        }
    }
}

@Preview
@Composable
private fun PaymentCardItemPreview() {
    ShopTheme {
        Row {
            PaymentCardItem(
                card = PaymentCard(
                    id = "1",
                    type = CardType.VISA,
                    lastFourDigits = "1921",
                    expiryDate = "07/25",
                    isSelected = true
                ),
                onClick = {}
            )

            Spacer(modifier = Modifier.width(12.dp))

            PaymentCardItem(
                card = PaymentCard(
                    id = "2",
                    type = CardType.VISA,
                    lastFourDigits = "5632",
                    expiryDate = "07/25",
                    isSelected = false
                ),
                onClick = {}
            )
        }
    }
}
