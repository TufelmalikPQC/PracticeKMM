package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.models.consts.ShippingMethod
import com.practice.kmm.theme.ShopTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.label_home_delivery
import practicekmm.composeapp.generated.resources.label_pickup_in_store

/**
 * Toggle between shipping methods.
 *
 * @param selectedMethod Currently selected shipping method
 * @param onMethodSelected Callback when method is selected
 * @param modifier Modifier for the component
 */
@Composable
fun ShippingToggle(
    selectedMethod: ShippingMethod,
    onMethodSelected: (ShippingMethod) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(4.dp)
    ) {
        ShippingOption(
            text = stringResource(Res.string.label_home_delivery),
            isSelected = selectedMethod == ShippingMethod.HOME_DELIVERY,
            onClick = { onMethodSelected(ShippingMethod.HOME_DELIVERY) },
            modifier = Modifier.weight(1f)
        )

        ShippingOption(
            text = stringResource(Res.string.label_pickup_in_store),
            isSelected = selectedMethod == ShippingMethod.STORE_PICKUP,
            onClick = { onMethodSelected(ShippingMethod.STORE_PICKUP) },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun ShippingOption(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(21.dp))
            .then(
                if (isSelected) {
                    Modifier.background(MaterialTheme.colorScheme.surface)
                } else {
                    Modifier
                }
            )
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal
            ),
            color = if (isSelected) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        )
    }
}

@Preview
@Composable
private fun ShippingTogglePreview() {
    ShopTheme {
        ShippingToggle(
            selectedMethod = ShippingMethod.HOME_DELIVERY,
            onMethodSelected = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}
