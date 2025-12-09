package com.practice.kmm.uiToolKit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.practice.kmm.models.entities.Product
import com.practice.kmm.theme.ShopTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import practicekmm.composeapp.generated.resources.Res
import practicekmm.composeapp.generated.resources.label_free_shipping

/**
 * Product card for displaying in grids and carousels.
 *
 * @param product Product data to display
 * @param onClick Callback when card is clicked
 * @param modifier Modifier for the component
 */
@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val extendedColors = ShopTheme.extendedColors

    Surface(
        modifier = modifier
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column {
            // Product Image Placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = product.name.take(2).uppercase(),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                // Product Name
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Price
                Text(
                    text = "$ ${product.price.toInt().toString().reversed().chunked(3).joinToString(",").reversed()}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = extendedColors.priceText
                )

                // Free Shipping Badge
                if (product.hasFreeShipping) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(Res.string.label_free_shipping),
                        style = MaterialTheme.typography.labelSmall,
                        color = extendedColors.freeShipping
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    ShopTheme {
        ProductCard(
            product = Product(
                id = "1",
                name = "Macbook Air M1",
                price = 29999.0,
                hasFreeShipping = true
            ),
            onClick = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}
